package com.example.user.projetmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListeAnonces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final List<Logements> logements;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_anonces);

        ListView list_logement = (ListView) findViewById(R.id.listview);
        logements=new ArrayList<Logements>();
        logements.add(new Logements("1500 DA","5","100 m2",R.drawable.image1));
        logements.add(new Logements("5500 DA","3","150 m2",R.drawable.image2));
        logements.add(new Logements("5500 DA","2","200 m2",R.drawable.image3));
        logements.add(new Logements("8900 DA","1","300 m2",R.drawable.image4));
        logements.add(new Logements("80900 DA","10","700 m2",R.drawable.image5));
        list_logement.setAdapter(new LogementAdapter((ArrayList) logements));
        list_logement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (isTwoPane()) {
                    ImageView image=(ImageView) findViewById(R.id.imageView4);
                    TextView prix=(TextView) findViewById(R.id.textView5);
                    TextView nbchambre=(TextView) findViewById(R.id.textView6);
                    TextView surface=(TextView) findViewById(R.id.textView7);


                    image.setImageResource(logements.get(position).getId_image());
                    prix.setText(logements.get(position).getPrix());
                    nbchambre.setText(logements.get(position).getNombre_chambre());
                    surface.setText(logements.get(position).getSurface());

                } else
                {
                    Intent intent=new Intent(ListeAnonces.this,DetailAnonces.class);
                    intent.putExtra("logement",logements.get(position));
                    startActivity(intent);
                }
            }
        });
    }
    public boolean isTwoPane() {
        View view =findViewById(R.id.fragment2);
        return (view!=null);
    }
}
