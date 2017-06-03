package com.iitd.dailab.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.iitd.dailab.Model.Movie;
import com.iitd.dailab.R;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder>{

    List<Movie> mItems;
    private Fragment context;
    private int flag = 0;
    public boolean show = false;
    private boolean show1 = false;
    private boolean show2 = false;
    private boolean show3 = false;

    public TestRecyclerViewAdapter() {
        super();
        mItems = new ArrayList<Movie>();

        Movie movie = new Movie();
        movie.setName("DAILAB @ AIST");
        movie.setName1("");

        mItems.add(movie);

        movie = new Movie();
        movie.setName("The Department of Biotechnology of India (DBT) and National Institute of Advanced Industrial Science and Technology (AIST, Japan) have established a new joint research laboratory, named DBT-AIST International Laboratory for Advanced Biomedicine (DAILAB) at AIST Tsukuba and RCB, India. AIST President Dr. Ryoji Chubachi and DBT Secretary Prof. K. VijayRaghavan signed the joint research contract and the opening ceremony was held on October 3, 2013, at AIST Tsukuba.\n" +
                "\n" +
                "AIST and DBT have concluded a comprehensive memorandum of understanding on comprehensive research cooperation (MoU) on February 12, 2007. This MoU involved bilateral collaboration on three themes - Bioinformatics, Biomedicine, and Glycoscience. During the last 7 years, AIST and DBT scientists have been performing and collaborating on selected projects at both end. Four workshops, two at each side, were held so far for exchange of ideas, information, and research results to develop closer collaboration between the two institutions.\n" +
                "\n" +
                "In order to promote close and effective collaboration, AIST and DBT have set up DAILAB at the Biomedical Research Institute of AIST in AIST Tsukuba. DAILAB conducts basic to applied research on cancer treatment and to improve the quality of life. The collaborative research offers a global vision to both institutions and helps in training many young researchers at both sides. This is the first time that AIST and DBT are hosting an international laboratory in the fields of life sciences and biotechnology. The two institutions have set up a parallel joint laboratory in India too. This has increased the efficacy of research projects and has offered opportunities for personnel exchange. Both institutions are keen to involve industry at a later stage of the projects so that the outcomes can be brought to society in the most effective way.");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("DAILAB Executive Team @ AIST");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. N. Yumoto, Fellow, AIST");
        movie.setName1("Patron");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. Y. Ohmiya, Director, BMRI, AIST");
        movie.setName1("Executive Director");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. R. Wadhwa, Prime Senior Researcher, AIST");
        movie.setName1("Leader");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. S. Kaul, Chief Senior Researcher, AIST");
        movie.setName1("Coordinator");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. Y. Onishi, Director, Research Planning, AIST");
        movie.setName1("Fellow");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. M. Doi, Group Leader, BMRI, AIST");
        movie.setName1("Fellow");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. D. Sundar, IIT Delhi");
        movie.setName1("Invited Guest Researcher");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Group Photograph");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Photo");
        movie.setName1("");
        movie.setThumbnail(R.drawable.jt);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Contact DAILAB @ AIST");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dr. Sunil Kaul\n" +
                "Coordinator, DAILAB");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Biomedical Research Institute\n" +
                "National Institute of Advanced Industrial Science and Technology (AIST) \n" +
                "Central 4 1-1-1 Higashi\n" +
                "Tsukuba, Ibarakai 305-8562\n" +
                "Japan");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("E-mail: s-kaul@aist.go.jp");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Visit our Website");
        movie.setName1("");
        mItems.add(movie);

    }


    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 1:
                return TYPE_HEADER;
            case 11:
                return TYPE_HEADER;
            case 14:
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
        if (i == 1||i==14) {
            viewHolder.imgThumbnail.setVisibility(View.GONE);
            viewHolder.tvMovie1.setVisibility(View.GONE);
        } else {
            viewHolder.imgThumbnail.setVisibility(View.VISIBLE);
            viewHolder.tvMovie1.setVisibility(View.VISIBLE);
        }
        if (i == 2||i==10||i==12||i==16) {
            viewHolder.card.setBackgroundColor(Color.parseColor("#3949AB"));
            viewHolder.tvMovie.setTextColor(Color.WHITE);
            viewHolder.card.setVisibility(View.VISIBLE);
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.down1);
            if(i==16)
                viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        else if (i == 0)
        {
            viewHolder.card.setBackgroundColor(Color.parseColor("#F44336"));
            viewHolder.tvMovie.setTextColor(Color.WHITE);
            viewHolder.card.setVisibility(View.VISIBLE);
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.down1);
        }
        else
        {
            viewHolder.card.setBackgroundColor(Color.WHITE);
            viewHolder.tvMovie.setTextColor(Color.BLACK);
        }
        if(i==1) {
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (!show) {
                viewHolder.card.setVisibility(View.GONE);
            } else {
                viewHolder.card.setVisibility(View.VISIBLE);
            }
        }
        if(i>=3&&i<=9) {
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (!show1) {
                viewHolder.card.setVisibility(View.GONE);
            } else {
                viewHolder.card.setVisibility(View.VISIBLE);
            }
        }
        if(i==11) {
            viewHolder.tvMovie1.setVisibility(View.GONE);
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (!show2) {
                viewHolder.card.setVisibility(View.GONE);
            } else {
                viewHolder.card.setVisibility(View.VISIBLE);
            }
        }
        if(i>=13&&i<=15) {
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (!show3) {
                viewHolder.card.setVisibility(View.GONE);
            } else {
                viewHolder.card.setVisibility(View.VISIBLE);
            }
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

                    if (feed.getName().equals("Introduction")) {
                        if (show) {
                            show = false;
                            notifyDataSetChanged();
                        } else {
                            show = true;
                            notifyDataSetChanged();
                        }
                    }
                    if (feed.getName().equals("DAILAB Executive Team @ AIST")) {
                        if (show1) {
                            show1 = false;
                            notifyDataSetChanged();
                        } else {
                            show1 = true;
                            notifyDataSetChanged();
                        }
                    }
                    if (feed.getName().equals("Group Photograph")) {
                        if (show2) {
                            show2 = false;
                            notifyDataSetChanged();
                        } else {
                            show2 = true;
                            notifyDataSetChanged();
                        }
                    }
                    if (feed.getName().equals("Contact DAILAB @ AIST")) {
                        if (show3) {
                            show3 = false;
                            notifyDataSetChanged();
                        } else {
                            show3 = true;
                            notifyDataSetChanged();
                        }
                    }
                    if (feed.getName().equals("Biomedical Research Institute\n" +
                            "National Institute of Advanced Industrial Science and Technology (AIST) \n" +
                            "Central 4 1-1-1 Higashi\n" +
                            "Tsukuba, Ibarakai 305-8562\n" +
                            "Japan")) {

                        Uri uri = Uri.parse("geo:0,0?q=36.0610488,140.1284448(Biomedical Research Institute)");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(v.getContext().getPackageManager()) != null) {
                            v.getContext().startActivity(mapIntent);
                        }
                    }
                    if (feed.getName().equals("E-mail: s-kaul@aist.go.jp")) {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto","s-kaul@aist.go.jp", null));
                        v.getContext().startActivity(Intent.createChooser(emailIntent, "Send Email Using..."));
                    }
                    if (feed.getName().equals("Visit our Website")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://unit.aist.go.jp/bmd/en/information/index.html"));
                        v.getContext().startActivity(intent);
                    }
                    if (feed.getName().equals("Photo")) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });/*.setNegativeButton("No thanks", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });*/
                        final AlertDialog dialog = builder.create();
                        LayoutInflater inflater = (LayoutInflater) v.getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                        View dialogLayout = inflater.inflate(R.layout.go_pro_dialog_layout, null);
                        dialog.setView(dialogLayout);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                        dialog.show();

                        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                            @Override
                            public void onShow(DialogInterface d) {
                                ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
                                Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                                        R.drawable.jt);
                                float imageWidthInPX = (float)image.getWidth();

                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(imageWidthInPX),
                                        Math.round(imageWidthInPX * (float)icon.getHeight() / (float)icon.getWidth()));
                                image.setLayoutParams(layoutParams);


                            }
                        });
                    }
                }
            });
        }
    }
}