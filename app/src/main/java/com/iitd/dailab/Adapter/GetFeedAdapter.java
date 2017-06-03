package com.iitd.dailab.Adapter;

/**
 * Created by Karthik on 22-06-2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import com.iitd.dailab.Model.FeedModel;
import com.iitd.dailab.R;


public class GetFeedAdapter extends RecyclerView.Adapter<GetFeedAdapter.MyViewHolder>  {

    private List<FeedModel> listData;
    private Activity activity;

    public GetFeedAdapter(List<FeedModel> list, Activity activity) {
        this.listData = list;
        this.activity = activity;
    }

    public GetFeedAdapter(ArrayList<List<FeedModel>> data) {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_for_feed, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        holder.title.setText(listData.get(position).getText());
        holder.date.setText(listData.get(position).getDate());

        if(listData.get(position).getDate() == null) {
            holder.date.setVisibility(View.GONE);
            holder.title.setGravity(Gravity.CENTER);
            holder.backcolor.setBackgroundColor(activity.getResources().getColor(R.color.red));
        }
        else
        {
            holder.backcolor.setBackgroundColor(activity.getResources().getColor(R.color.colorPrimaryDark));
            holder.date.setVisibility(View.VISIBLE);
            holder.title.setGravity(Gravity.START);
        }
        holder.card.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position =  holder.getAdapterPosition();
                System.out.println(position);

                //Toast.makeText(v.getContext(), listData.get(position).getLink(), Toast.LENGTH_SHORT).show();
                if(listData.get(position).getLink()!=null) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(listData.get(position).getLink()));
                    activity.startActivity(browserIntent);
                }
            }

        });
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title, date;
        public CardView card;
        LinearLayout backcolor;

        public MyViewHolder(View view)
        {
            super(view);
            title = (TextView) view.findViewById(R.id.textView);
            date = (TextView) view.findViewById(R.id.textView1);
            card = (CardView) view.findViewById(R.id.card);
            backcolor = (LinearLayout)view.findViewById(R.id.backcolor);
        }
    }
}
