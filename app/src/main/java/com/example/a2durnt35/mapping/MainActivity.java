package com.example.a2durnt35.mapping;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

public class MainActivity extends AppCompatActivity
{

    MapView mv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(50.907479,-1.413357));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;
        }

        if(item.getItemId() == R.id.SetLocation)
        {
            Intent intent = new Intent(this,SetLocationActivity.class);
            startActivityForResult(intent,1);
            return true;
        }

        if(item.getItemId() == R.id.preferences)
        {
            Intent intent = new Intent(this,PreferencesActivity.class);
            startActivityForResult(intent,2);
            return true;
        }
        return false;
    }




    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebikemap = extras.getBoolean("com.example.a2durnt35.mapping.hikebikemap");
                if(hikebikemap==true)
                {
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }

        }
        if (requestCode==1)
        {
            if (resultCode==RESULT_OK) {

                Bundle extras = intent.getExtras();

                double lat = extras.getDouble("com.example.a2durnt35.mapping.latitude");
                double lon = extras.getDouble("com.example.a2durnt35.mapping.longitude");

                mv.getController().setCenter(new GeoPoint(lat,lon));
            }
        }
    }



    public void onStart()
    {
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        double lat = Double.parseDouble ( prefs.getString("lat", "50.9") );
        double lon = Double.parseDouble ( prefs.getString("lon", "-1.4") );
        Integer zoom = Integer.parseInt( prefs.getString("zoom", "10") );
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(zoom);
        mv.getController().setCenter(new GeoPoint(lat,lon));

    }


}