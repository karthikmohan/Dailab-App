package com.iitd.dailab.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
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

public class TestRecyclerViewAdapter1 extends RecyclerView.Adapter<TestRecyclerViewAdapter1.ViewHolder>{

    List<Movie> mItems;
    private Fragment context;
    private int flag = 0;
    private boolean show = false;
    private boolean show1 = false;
    private boolean show2 = false;
    private boolean show3 = false;

    public TestRecyclerViewAdapter1() {
        super();
        mItems = new ArrayList<Movie>();

        Movie movie = new Movie();
        movie.setName("DAILAB @ IIT Delhi");
        movie.setName1("");

        mItems.add(movie);

        movie = new Movie();
        movie.setName("The collaboration between IIT Delhi and AIST has its origin in the year 2010 and has been highly successful so far. Both IIT Delhi and AIST have been working together for five years now even when no formal MoU existed between both the Institutions. The collaboration has been very active both in research as well as in organizing educational and training programs at both sides. On the research front, various aspects of understanding the anti-cancer activity of key withanolides from Indian Ayurvedic herb Ashwagandha has the topic of the collaboration so far. In one such study, IIT Delhi was involved in the in silico investigation of the interactions of withanone with the homology built structure of mortalin (a novel member of heat shock protein cloned by DAILAB and reported to be involved in carcinogenesis) and found that the withanone could bind to mortalin in a region earlier predicted critical for binding to p53. Molecular dynamic simulations were performed at IIT Delhi, which revealed the thermodynamic and structural stability of the withanone-mortalin complexes. This study was subsequently taken up by AIST to further demonstrate the experimental evidence of abrogation of mortalin-p53 complex by withanone resulting in an activation of p53 in human cancer cells. Similarly, joint publications on the cellular target TPX2-Aurora 2 that acts as substrates of withanone, molecular interactions of Bcl-2 & Bcl-xL with mortalin have demonstrated that these phytochemicals caused down-regulation of migration-promoting proteins hnRNP-K, VEGF and metalloproteases.\n" +
                "\n" +
                "The research collaboration between AIST and IIT Delhi was initiated after the interaction during the visit of AIST delegation to IIT Delhi for participating in the 2nd Indo-Japan Symposium on Bioinformatics (Dec 10-11, 2010) and the 4th (DBT) India- (AIST) Japan Workshop on Cell Engineering and Bioinformatics (Dec 13-14, 2010) that was hosted by us. The interaction during this meeting was very fruitful and both our groups started working together on various aspects of Ashwagandha research that has resulted in several international publications. The highlight of this collaboration has been the integration of complementary research expertise available between the two groups. Both the groups have drawn strength from their past accomplishments in the molecular analysis using bioinformatics and biochemical approaches as well as recent developments in molecular sciences. The novel targeted approach to investigate the anticancer and neurodegenerative activities of the metabolites from Ashwagandha, will help to overcome the challenges and roadblocks that prevent us from developing a novel, cheap and natural anticancer drug to serve as an alternative for modern medicine.\n" +
                "\n" +
                "The proposal for MoU between IIT Delhi and AIST was approved in March 2015. The agreement of cooperation between both the Institutions was exchanged in the AIST-IITD Introductory Symposium held at AIST, Tsukuba on June 18, 2015. The IIT Delhi delegation that participated in the meeting included Prof. S.K. Koul, Deputy Director (S&P), Prof. Suneet Tuli, Dean (R&D) and Dr. D. Sundar, Associate Professor, DBEB. Subsequently, the proposal for setting up a DAILAB at IIT Delhi was approved by our Institute with the following objectives: (i)\tprovide an opportunity for IITD faculty and AIST scientists to bring complementary expertise and innovative problem solving capabilities (ii) conduct research at a larger scope leveraging the infrastructure/expertise at both the institutions.");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("DAILAB Team @ IIT Delhi");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. Suneet Tuli, Dean (R&D), IIT Delhi - AIST MoU");
        movie.setName1("Coordinator");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. Durai Sundar, DAILAB @ IIT Delhi");
        movie.setName1("Coordinator");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. Ritu Kulshreshta");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. Ravikrishnan Elangovan");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. Vivekanandan Perumal");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. Veena Koul");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Group Photograph");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Photo");
        movie.setName1("");
        movie.setThumbnail(R.drawable.gp);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Contact DAILAB @ IIT Delhi");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Prof. D. Sundar\n" +
                "Coordinator, DAILAB");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Department of Biochemical Engineering and Biotechnology\n" +
                "Indian Institute of Technology (IIT) Delhi\n" +
                "Hauz Khas, New Delhi - 110016\n" +
                "India");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Email: dailab@iitd.ac.in");
        movie.setName1("");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("URL: http://web.iitd.ac.in/~sundar/dailab");
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
            case 10:
                return TYPE_HEADER;
            case 13:
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
        if (i == 1||i==13) {
            viewHolder.imgThumbnail.setVisibility(View.GONE);
            viewHolder.tvMovie1.setVisibility(View.GONE);
        } else {
            viewHolder.imgThumbnail.setVisibility(View.VISIBLE);
            viewHolder.tvMovie1.setVisibility(View.VISIBLE);
        }
        if (i == 2||i==9||i==11||i==16) {
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
        if(i>=3&&i<=8) {
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (!show1) {
                viewHolder.card.setVisibility(View.GONE);
            } else {
                viewHolder.card.setVisibility(View.VISIBLE);
            }
        }
        if(i==10) {
            viewHolder.tvMovie.setVisibility(View.GONE);
            viewHolder.tvMovie.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (!show2) {
                viewHolder.card.setVisibility(View.GONE);
            } else {
                viewHolder.card.setVisibility(View.VISIBLE);
            }
        }
        if(i>=12&&i<=15) {

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
                    if (feed.getName().equals("DAILAB Team @ IIT Delhi")) {
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
                    if (feed.getName().equals("Contact DAILAB @ IIT Delhi")) {
                        if (show3) {
                            show3 = false;
                            notifyDataSetChanged();
                        } else {
                            show3 = true;
                            notifyDataSetChanged();
                        }
                    }
                    if (feed.getName().equals("Department of Biochemical Engineering and Biotechnology\n" +
                            "Indian Institute of Technology (IIT) Delhi\n" +
                            "Hauz Khas, New Delhi - 110016\n" +
                            "India")) {
                        Uri uri = Uri.parse("geo:0,0?q=28.5417055,77.1922608(Indian Institute of Technology, Delhi)");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(v.getContext().getPackageManager()) != null) {
                            v.getContext().startActivity(mapIntent);
                        }
                    }
                    if (feed.getName().equals("Email: dailab@iitd.ac.in")) {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto","dailab@iitd.ac.in", null));
                        v.getContext().startActivity(Intent.createChooser(emailIntent, "Send Email Using..."));
                    }
                    if (feed.getName().equals("URL: http://web.iitd.ac.in/~sundar/dailab")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://web.iitd.ac.in/~sundar/dailab"));
                        v.getContext().startActivity(intent);
                    }
                    if (feed.getName().equals("Visit our Website")) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://web.iitd.ac.in/~sundar/meeting/piknikh2015-2/"));
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
                        View dialogLayout = inflater.inflate(R.layout.go_pro_dialog_layout1, null);
                        dialog.setView(dialogLayout);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                        dialog.show();

                        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                            @Override
                            public void onShow(DialogInterface d) {
                                ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
                                Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                                        R.drawable.gp);
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