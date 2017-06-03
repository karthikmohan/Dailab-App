package com.iitd.dailab.Adapter;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.iitd.dailab.Model.Movie;
import com.iitd.dailab.R;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewAdapter2 extends RecyclerView.Adapter<TestRecyclerViewAdapter2.ViewHolder>{

    List<Movie> mItems;
    private Fragment context;
    private int flag = 0;
    private boolean show = false;
    private boolean show1 = false;
    private boolean show2 = false;
    private boolean show3 = false;

    public TestRecyclerViewAdapter2() {
        super();
        mItems = new ArrayList<Movie>();

        Movie movie = new Movie();
        movie.setName("1");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio1);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("2");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("3");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio3);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("4");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio4);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("5");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio5);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("6");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio6);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("7");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio7);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("8");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio8);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("9");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio9);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("10");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio10);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("11");
        movie.setName1("");
        movie.setThumbnail(R.drawable.portfolio11);
        mItems.add(movie);
    }


    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            default:
                return TYPE_HEADER;
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
            viewHolder.tvMovie.setVisibility(View.GONE);
            viewHolder.tvMovie1.setVisibility(View.GONE);

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

                    if (feed.getName().equals("1")) {
                        final Dialog dialog = new Dialog(v.getContext());
                        dialog.setContentView(R.layout.custom_dialog);
                        dialog.setTitle("Title");
                        ScrollView scroll = new ScrollView(v.getContext());
                        scroll.setBackgroundColor(v.getResources().getColor(android.R.color.transparent));
                        scroll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                        // set the custom dialog components - text, image and button
                        TextView text = (TextView) dialog.findViewById(R.id.text);
                        text.setText("This STAR program offers internship opportunity in an international and highly organized environment at AIST, Japan for a period for 3 months to a year. Several young researchers are already benefitted from this program.");
                        TextView text1 = (TextView) dialog.findViewById(R.id.flyer);
                        text1.setText("http://web.iitd.ac.in/~sundar/dailab/PDFs/STAR-Program-Advt.pdf");
                        ImageView image = (ImageView) dialog.findViewById(R.id.image);
                        image.setImageResource(R.drawable.star_one);
                        image = (ImageView) dialog.findViewById(R.id.image1);
                        image.setImageResource(R.drawable.star_two);
                        Button btn = (Button) dialog.findViewById(R.id.button);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(final View v) {
                                dialog.cancel();
                            }
                    });
                        dialog.show();
                    }
                    if (feed.getName().equals("2")) {
                        final Dialog dialog = new Dialog(v.getContext());
                        dialog.setContentView(R.layout.custom_dialog);
                        dialog.setTitle("Title");
                        ScrollView scroll = new ScrollView(v.getContext());
                        scroll.setBackgroundColor(v.getResources().getColor(android.R.color.transparent));
                        scroll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                        // set the custom dialog components - text, image and button
                        TextView text = (TextView) dialog.findViewById(R.id.text);
                        text.setText("CAFÉ is held once in six weeks and provides a relaxed CAFÉ-like environment for study and learning. This is a Classroom setting rather than a lecture on data presentation. Frontier topics are selected for CAFÉ talks that are presented by eminent scientists on an educational level and are skyped to all the overseas institutions (DAILAB CAFE and its Satellites). Participating Institutions include AIST (Tsukuba, Japan), IIT Delhi (India), Hanyang University (South Korea), Peking Medical University (China) and Brawijaya University (Indonesia).");
                        TextView text1 = (TextView) dialog.findViewById(R.id.flyer);
                        text1.setText("http://web.iitd.ac.in/~sundar/dailab/PDFs/STAR-Program-Advt.pdf");
                        ImageView image = (ImageView) dialog.findViewById(R.id.image);
                        image.setImageResource(R.drawable.cafe1);
                        image = (ImageView) dialog.findViewById(R.id.image1);
                        image.setImageResource(R.drawable.cafe2);
                        Button btn = (Button) dialog.findViewById(R.id.button);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(final View v) {
                                dialog.cancel();
                            }
                        });
                        dialog.show();
                    }
                    if (feed.getName().equals("3")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("4")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("5")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("6")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("7")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("8")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("9")) {
                        System.out.println("Hello");
                    }
                    if (feed.getName().equals("10")) {
                        System.out.println("Hello");
                    }
                }
            });
        }
    }
}