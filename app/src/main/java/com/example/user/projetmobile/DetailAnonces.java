package com.example.user.projetmobile;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import me.relex.circleindicator.CircleIndicator;


public class DetailAnonces extends AppCompatActivity  implements OnMapReadyCallback {


    private GoogleMap mMap;
    Boolean bool=true;
    ViewPager viewPager;
    customSwip customswip;
    Logement log = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA", "200m²", "3", R.drawable.image1, "BEJAIA", "Appartement", R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image2);
    ImageButton imageButton,imageButtonplus,imageButtonmoin;
    LatLng x = new LatLng(36.71, 5.071);



    int i=13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Détail de l'annonce");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anonces);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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

        CircleIndicator circleIndicator=(CircleIndicator) findViewById(R.id.indicator);
        circleIndicator.setBackgroundColor(0x54000000);
        circleIndicator.setViewPager(viewPager);
        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButtonmoin=(ImageButton)findViewById(R.id.imageButtonmoin);
        imageButtonplus=(ImageButton)findViewById(R.id.imageButtonplus);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bool==true){
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    bool=false;
                }else{

                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    bool=true;
                }
            }
        });

        imageButtonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(x,i++));
            }
        });
        imageButtonmoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(x,i--));
            }
        });


        // bouton contacter et rdv
        Button contacter = (Button) findViewById(R.id.contcter);


        contacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:123456789"));
                if (ActivityCompat.checkSelfPermission(DetailAnonces.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                int mYear = mcurrentTime.get(Calendar.YEAR); // current year
                int mMonth = mcurrentTime.get(Calendar.MONTH); // current month
                int mDay = mcurrentTime.get(Calendar.DAY_OF_MONTH); // current day
                TimePickerDialog mTimePicker;


                mTimePicker = new TimePickerDialog(DetailAnonces.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        //time.setText(selectedHour + ":" + selectedMinute);

                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Choisir l'horaire:");

                mTimePicker.show();

        DatePickerDialog mDatePicker;
        mDatePicker=new DatePickerDialog(DetailAnonces.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // set day of month , month and year value in the edit text
              /*  date.setText(dayOfMonth + "/"
                        + (monthOfYear + 1) + "/" + year);*/
            }
        }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Choisir la Date :");
                //mDatePicker.setAccentColor("#9C27B0");
                mDatePicker.show();
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in Sydney and move the camera

        MarkerOptions markerOptions =new MarkerOptions().position(x).title("abane ramdane");
        CircleOptions circleOptions = new CircleOptions().center(x).radius(1000).fillColor(0xffffff0).strokeColor(0xffff0000).strokeWidth(2);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.image_pic));
        mMap.addMarker(markerOptions);
        mMap.addCircle(circleOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(x, 13));
    }
}
