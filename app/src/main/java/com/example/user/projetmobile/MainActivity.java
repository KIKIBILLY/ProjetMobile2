package com.example.user.projetmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static List<Logement> logementList=new ArrayList<>();
    public static List<Logement> logementListprete=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Recherche");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int[] covers = new int[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5};
        //----------------------------------------APPARTEMENT ------------------------------------------//
        Logement a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" , covers[0], "BEJAIA","Appartement",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[1],"ALGER","Appartement",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[2], "ORAN","Appartement",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3",covers[3],"BECHAR","Appartement",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3", covers[4], "ANNABA","Appartement",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);
        //------------------------------------STUDIO----------------------------------------------------------//

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3", covers[0], "BEJAIA","studio",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" , covers[0], "ALGER","studio",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);


        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[1],"ORAN","studio",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[2], "BECHAR","studio",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3",covers[3],"ANNABA","studio",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);
        //--------------------------------------DUPLEX--------------------------------------------------------//
        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3", covers[4], "ALGER","Duplex",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);
        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" , covers[0], "ORAN","Duplex",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[1],"BECHAR","Duplex",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[2], "BEJAIA","Duplex",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3",covers[3],"ANNABA","Duplex",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);
        //--------------------------------------VILLA--------------------------------------------------------//
        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3", covers[4], "ORAN","Villa",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);


        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[1],"BECHAR","Villa",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[2], "BEJAIA","Villa",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3",covers[3],"ALGER","Villa",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3", covers[4], "ANNABA","Villa",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);


        //--------------------------------------CABANON--------------------------------------------------------//

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[1],"BECHAR","Cabanon",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[2], "BEJAIA","Cabanon",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3",covers[3],"ALGER","Cabanon",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);

        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3", covers[4], "ORAN","Cabanon",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);


        a = new Logement("Sidi ali labhar,Bejaia 06000.","1000000.00 DA","200m²", "3" ,covers[1],"ANNABA","Cabanon",covers[0],covers[1],covers[2],covers[0],covers[4]);
        logementList.add(a);





        //-----------------------------

        for (int i=0;i<(logementList.size()-1);i++){
            if (logementList.get(i).getRegion().equalsIgnoreCase("BEJAIA")){
                logementListprete.add(logementList.get(i));
            }
            else{
                System.out.println("yes");
            }
        }

        //-----------------------------gestion de la connexion au compte gmail -------------------------------//


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        Button bt1=(Button) findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListeAnonces.class);
                //Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);



            }
        });










    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public  static  ArrayList<Logement> getlist(){
        return (ArrayList<Logement>) logementListprete;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {

        } else if (id == R.id.nav_list) {
            Intent intent=new Intent(MainActivity.this,shortlist.class);
            startActivity(intent);

        } else if (id == R.id.nav_save) {
            Intent intent=new Intent(MainActivity.this,recherchesauvegardee.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent=new Intent(MainActivity.this,parametre.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
