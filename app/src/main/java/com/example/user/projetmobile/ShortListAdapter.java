package com.example.user.projetmobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 26/03/2017.
 */

public class ShortListAdapter extends RecyclerView.Adapter<ShortListAdapter.MyViewHolder> {
    private Context mContext;
    private List<Logement> logementList;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView prix, surface;
        public ImageView image_anonce, coeur;




        public MyViewHolder(View view) {
            super(view);

            prix = (TextView) view.findViewById(R.id.prix);
            surface = (TextView) view.findViewById(R.id.surface);
            image_anonce = (ImageView) view.findViewById(R.id.image_anonce);
            coeur = (ImageView) view.findViewById(R.id.coeur);
            coeur.setTag(R.drawable.ic_liked);
            coeur.setImageResource(R.drawable.ic_liked);
            coeur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int positionshort2 = getAdapterPosition();

                    coeur.setTag(R.drawable.ic_like);
                    coeur.setImageResource(R.drawable.ic_like);
                    Toast.makeText(mContext,"Element supprimé de la shortlist",Toast.LENGTH_SHORT).show();
                    logementList.remove(positionshort2);
                }
            });

            image_anonce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent=new Intent(mContext,DetailAnonces.class);
                    intent.putExtra("logement",logementList.get(position));
                    mContext.startActivity(intent);
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent=new Intent(mContext,DetailAnonces.class);
                    intent.putExtra("logement",logementList.get(position));
                    mContext.startActivity(intent);
                }
            });

        }
    }


    public ShortListAdapter(Context mContext, List<Logement> albumList) {
        this.mContext = mContext;
        this.logementList = albumList;

    }



    @Override
    public ShortListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anonce_card, parent, false);

        return new ShortListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ShortListAdapter.MyViewHolder holder, int position) {
        Logement album = logementList.get(position);
        holder.prix.setText(album.getPrix());
        holder.surface.setText(album.getSurface() + "  ("+ album.getNbchambre()+")");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getId_image()).into(holder.image_anonce);
        holder.coeur.setTag(R.drawable.ic_like);


    }



    /**
     * Click listener for popup menu items
     */







    @Override
    public int getItemCount() {
        return logementList.size();
    }
}
