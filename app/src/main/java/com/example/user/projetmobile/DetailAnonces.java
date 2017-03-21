package com.example.user.projetmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAnonces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anonces);
        Intent intent=getIntent();
        Logements logements=(Logements) intent.getSerializableExtra("logement");

        ImageView image=(ImageView) findViewById(R.id.imageView4);
        TextView prix=(TextView) findViewById(R.id.textView5);
        TextView nbchambre=(TextView) findViewById(R.id.textView6);
        TextView surface=(TextView) findViewById(R.id.textView7);


        image.setImageResource(logements.getId_image());
        prix.setText(logements.getPrix());
        nbchambre.setText(logements.getNombre_chambre());
        surface.setText(logements.getSurface());

    }
}
