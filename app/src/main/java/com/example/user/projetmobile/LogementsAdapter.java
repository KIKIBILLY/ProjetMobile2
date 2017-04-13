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
import android.support.design.widget.Snackbar;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23/03/2017.
 */

public class LogementsAdapter extends RecyclerView.Adapter<LogementsAdapter.MyViewHolder> {

    public Context mContext;
    public List<Logement> logementList;
    public List<Logement> shortlist=new ArrayList<Logement>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView prix, surface,adresse;
        public ImageView image_anonce, coeur;

        public MyViewHolder(View view) {
            super(view);

            prix = (TextView) view.findViewById(R.id.prix);
            surface = (TextView) view.findViewById(R.id.surface);
            adresse = (TextView) view.findViewById(R.id.adresse);
            image_anonce = (ImageView) view.findViewById(R.id.image_anonce);
            coeur = (ImageView) view.findViewById(R.id.coeur);
            coeur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id=(int) coeur.getTag();
                    if( id == R.drawable.ic_like){
                        int positionshort1 = getAdapterPosition();
                        coeur.setTag(R.drawable.ic_liked);
                        coeur.setImageResource(R.drawable.ic_liked);
                        Toast.makeText(mContext,"Ajoutée à la shortlist",Toast.LENGTH_SHORT).show();
                        shortlist.add(logementList.get(positionshort1));

                    }else{
                        int positionshort2 = getAdapterPosition();
                        coeur.setTag(R.drawable.ic_like);
                        coeur.setImageResource(R.drawable.ic_like);
                        Toast.makeText(mContext,"Supprimée de la shortlist",Toast.LENGTH_SHORT).show();
                       int sup=shortlist.indexOf(logementList.get(positionshort2));
                        shortlist.remove(sup);

                    }
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


    public LogementsAdapter(Context mContext, List<Logement> albumList) {
        this.mContext = mContext;
        this.logementList = albumList;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anonce_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Logement logement = logementList.get(position);
        holder.prix.setText(logement.getPrix());
        holder.surface.setText(logement.getSurface() + " " + logement.getNbchambre() +"  chambre(s)");
        holder.adresse.setText(logement.getAdresse());

        // loading logement cover using Glide library
        Glide.with(mContext).load(logement.getId_image()).into(holder.image_anonce);
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

