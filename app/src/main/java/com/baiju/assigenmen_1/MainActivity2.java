package com.baiju.assigenmen_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements LocationListener {

    Button btn_location;
    TextView text_location;
    LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_location = findViewById(R.id.text_location);
        btn_location = findViewById(R.id.btn_location);

        if (ContextCompat.checkSelfPermission(MainActivity2.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(MainActivity2.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }


        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create method
                getLocation();

            }
        });


    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager =(LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,MainActivity2.this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

        Toast.makeText(this, ""+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();

        try {

            Geocoder geocoder = new Geocoder(MainActivity2.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address = addresses.get(0).getAddressLine(0);
            text_location.setText(address);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}