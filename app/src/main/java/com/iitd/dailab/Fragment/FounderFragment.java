package com.iitd.dailab.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iitd.dailab.Adapter.GetFeedAdapter;
import com.iitd.dailab.Model.FeedModel;
import com.iitd.dailab.R;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alienware on 27-05-2017.
 */

public class FounderFragment extends Fragment {


    private RecyclerView recyclerView;
    private GetFeedAdapter mAdapter;
    private List<FeedModel> listData = new ArrayList<>();
    private ProgressWheel progressWheel;
    private PullToRefreshView mPullToRefreshView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.founder, container, false);
        return view;
    }
}