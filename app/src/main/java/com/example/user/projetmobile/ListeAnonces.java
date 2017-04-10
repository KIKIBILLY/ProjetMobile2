package com.example.user.projetmobile;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static android.app.PendingIntent.getActivity;

public class ListeAnonces extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static LogementsAdapter adapter;
    public List<Logement> logementList,shortlist;
    public static List<Logement> logementList0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_anonces);
        this.setTitle("Liste des Annonces");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        logementList = new ArrayList<>();
        shortlist=new ArrayList<>();
        logementList0=new ArrayList<>();

        adapter = new LogementsAdapter(this, logementList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
       // recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        shortlist=adapter.shortlist;
        prepareAlbums();


        adapter.notifyDataSetChanged();


    }
public  static  ArrayList<Logement> getshortlist(){
        return (ArrayList<Logement>) adapter.shortlist;
    }
    public  static  ArrayList<Logement> getlonglist(){
        return (ArrayList<Logement>) logementList0;
    }
    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll

     /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        for(int i=0;i<MainActivity.getlist().size();i++){
            logementList.add(MainActivity.getlist().get(i));
        }

    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    public boolean isTwoPane() {
        View view = findViewById(R.id.fragment2);
        return (view!=null);
    }
}
