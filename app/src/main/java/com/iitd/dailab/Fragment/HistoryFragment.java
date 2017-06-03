package com.iitd.dailab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iitd.dailab.Adapter.GetFeedAdapter;
import com.iitd.dailab.Api.FeedApi;
import com.iitd.dailab.Constants.AppConstants;
import com.iitd.dailab.Model.FeedModel;
import com.iitd.dailab.R;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alienware on 26-05-2017.
 */

public class HistoryFragment extends Fragment {


    private RecyclerView recyclerView;
    private GetFeedAdapter mAdapter;
    private List<FeedModel> listData = new ArrayList<>();
    private ProgressWheel progressWheel;
    private PullToRefreshView mPullToRefreshView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history, container, false);
        initViews(view);
        pulltorefresh(view);
        return view;
    }

    private void initViews(View view){
        progressWheel = (ProgressWheel) view.findViewById(R.id.progress_wheel);
        progressWheel.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        listData = new ArrayList<>();
        mAdapter = new GetFeedAdapter(listData, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mAdapter);
        fetchData();
    }

    private void pulltorefresh(View view) {
        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fetchData();
                        mPullToRefreshView.setRefreshing(false);

                    }
                }, 2000);
            }
        });
    }

    private void fetchData()
    {
        listData.clear();
        Log.e("TAG", "in fetchData");
        progressWheel.setVisibility(View.VISIBLE);
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FeedApi service = retrofit.create(FeedApi.class);

        Call<FeedApi.FeedModelResponse> call = service.getfeed();

        call.enqueue(new Callback<FeedApi.FeedModelResponse>() {

            @Override
            public void onResponse(Call<FeedApi.FeedModelResponse> call, Response<FeedApi.FeedModelResponse> response) {
                Log.e("TAG", "in fetchData response");
                FeedApi.FeedModelResponse FeedModelResponse = response.body();

                progressWheel.setVisibility(View.GONE);
                listData.addAll(FeedModelResponse.getFeedModelList());
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<FeedApi.FeedModelResponse> call, Throwable t)
            {
                Log.e("TAG", "in getUserInfo response error");
                progressWheel.setVisibility(View.GONE);
            }
        });
    }

}