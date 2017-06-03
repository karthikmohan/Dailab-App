package com.iitd.dailab.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.iitd.dailab.Model.Movie;
import com.iitd.dailab.R;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewAdapter3 extends RecyclerView.Adapter<TestRecyclerViewAdapter3.ViewHolder>{

    List<Movie> mItems;

    public TestRecyclerViewAdapter3() {
        super();
        mItems = new ArrayList<Movie>();

        Movie movie = new Movie();
        movie.setName("VOL.1 (MAY 2014)");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("2");
        movie.setName1("Click to open");
        movie.setThumbnail(R.drawable.news1);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("VOL.2 (MAY 2015)");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("4");
        movie.setName1("");
        movie.setThumbnail(R.drawable.news2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("VOL.3 (AUG 2015)");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("6");
        movie.setName1("");
        movie.setThumbnail(R.drawable.news3);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("VOL.4 (MARCH 2016)");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("8");
        movie.setName1("");
        movie.setThumbnail(R.drawable.news4);
        mItems.add(movie);
    }

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 1:
                return TYPE_HEADER;
            case 3:
                return TYPE_HEADER;
            case 5:
                return TYPE_HEADER;
            case 7:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                ViewHolder viewHolder = new ViewHolder(v);
                return viewHolder;
            }
            case TYPE_CELL: {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                ViewHolder viewHolder = new ViewHolder(v);
                return viewHolder;
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        switch (getItemViewType(i)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
        if(i==0||i==2||i==4||i==6) {
            viewHolder.card.setBackgroundColor(Color.parseColor("#3949AB"));
            viewHolder.tvMovie.setTextColor(Color.WHITE);
            viewHolder.card.setVisibility(View.VISIBLE);
            viewHolder.imgThumbnail.setVisibility(View.GONE);
            viewHolder.tvMovie1.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.tvMovie.setVisibility(View.GONE);
            viewHolder.tvMovie1.setVisibility(View.GONE);
        }
        Movie fp = mItems.get(i);
        Movie movie = mItems.get(i);
        viewHolder.tvMovie.setText(movie.getName());
        viewHolder.tvMovie1.setText(movie.getName1());
        viewHolder.imgThumbnail.setImageResource(movie.getThumbnail());
        viewHolder.feed = fp;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvMovie;
        public TextView tvMovie1;
        public Movie feed;
        private AlertDialog.Builder builder;
        private CardView card;

        public ViewHolder(final View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView)itemView.findViewById(R.id.tv_title);
            tvMovie1 = (TextView)itemView.findViewById(R.id.tv_title1);
            card = (CardView)itemView.findViewById(R.id.card_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    if (feed.getName().equals("2")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://web.iitd.ac.in/~sundar/dailab/PDFs/DAILAB-Newsletter-Vol-1-May-2014.pdf"));
                        v.getContext().startActivity(intent);
                    }
                    if (feed.getName().equals("4")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://web.iitd.ac.in/~sundar/dailab/PDFs/DAILAB-Newsletter-Vol-2-Jan-2015.pdf"));
                        v.getContext().startActivity(intent);
                    }
                    if (feed.getName().equals("6")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://web.iitd.ac.in/~sundar/dailab/PDFs/DAILAB-Newsletter-Vol-3-Aug-2015.pdf"));
                        v.getContext().startActivity(intent);
                    }
                    if (feed.getName().equals("8")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://web.iitd.ac.in/~sundar/dailab/PDFs/DAILAB-Newsletter-Vol-4-March-2016.pdf"));
                        v.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}