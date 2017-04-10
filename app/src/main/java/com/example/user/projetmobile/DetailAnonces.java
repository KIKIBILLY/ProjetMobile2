package com.example.user.projetmobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class DetailAnonces extends AppCompatActivity {


    ViewPager viewPager;
    customSwip customswip;
    Logement log = new Logement("1000000.00 DA", "200m²", "3", R.drawable.image1, "BEJAIA", "Appartement", R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Détail de l'annonce");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anonces);
        TabHost tab = (TabHost) findViewById(R.id.tabHost);
        tab.setup();
        TabHost.TabSpec spec1 = tab.newTabSpec("DETAILS");




        spec1.setIndicator("DETAILS");

        spec1.setContent(R.id.layout1);
        tab.addTab(spec1);

        TabHost.TabSpec spec2 = tab.newTabSpec("MAP");
        spec2.setIndicator("MAP");
        spec2.setContent(R.id.layout2);
        tab.addTab(spec2);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        customswip = new customSwip(this, log.imageResources);
        viewPager.setAdapter(customswip);


        // bouton contacter
        Button contacter = (Button) findViewById(R.id.contcter);
        contacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:123456789"));
                if (ActivityCompat.checkSelfPermission(DetailAnonces.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }
        });


        Button rdv = (Button) findViewById(R.id.rdv);
        rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });




/*



        ImageView image=(ImageView) findViewById(R.id.imageView4);
        TextView prix=(TextView) findViewById(R.id.textView5);
        TextView nbchambre=(TextView) findViewById(R.id.textView6);
        TextView surface=(TextView) findViewById(R.id.textView7);


        image.setImageResource(logements.getId_image());
        prix.setText(logements.getPrix());
        nbchambre.setText(logements.getNbchambre());
        surface.setText(logements.getSurface());
*/
    }
}
