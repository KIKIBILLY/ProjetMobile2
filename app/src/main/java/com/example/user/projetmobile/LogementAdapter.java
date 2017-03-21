package com.example.user.projetmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 21/03/2017.
 */

public class LogementAdapter extends BaseAdapter {

    ArrayList<Logements> logements;
    public LogementAdapter(ArrayList<Logements> logements ) {
        this.logements=logements;
    }

    @Override
    public int getCount() {
        return logements.size();
    }

    @Override
    public Object getItem(int position) {
        return logements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ligne= LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_ligne,parent,false);
        ImageView image=(ImageView) ligne.findViewById(R.id.imageView3);
        TextView prix=(TextView) ligne.findViewById(R.id.textView3);
        TextView nbchambre=(TextView) ligne.findViewById(R.id.textView4);
        TextView surface=(TextView) ligne.findViewById(R.id.textView2);

        image.setImageResource(logements.get(position).getId_image());
        prix.setText(logements.get(position).getPrix().toString());
        nbchambre.setText(logements.get(position).getNombre_chambre().toString());
        surface.setText(logements.get(position).getSurface().toString());

        return ligne;
    }
}
