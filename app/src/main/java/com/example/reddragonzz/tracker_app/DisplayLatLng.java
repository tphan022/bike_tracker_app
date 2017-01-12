package com.example.reddragonzz.tracker_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DisplayLatLng extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lat_lng);

        //Intent intent = getIntent();
        //String LatLng = intent.getStringExtra(RequestLatLng.EXTRA_MESSAGE);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        // Zoom level after inputting coordinates
        float Zoom = 16;


        Intent intent = getIntent();
        String LatLong = intent.getStringExtra(RequestLatLng.EXTRA_MESSAGE);
        // TODO: Create if else statement to catch none string array size: 2
        // TODO: Remove comma from string before parsing it to double
        String[] LatLong2 = LatLong.split("\\s+");

        int array_size = LatLong2.length;
        if(array_size == 2 && LatLong2[0].matches(".*\\d.*") && LatLong2[1].matches(".*\\d.*")) {


            // replaceAll gets rid of all non-numeric characters
            LatLong2[0] = LatLong2[0].replaceAll("[^\\d.-]", "");
            LatLong2[1] = LatLong2[1].replaceAll("[^\\d.-]", "");

            // TODO: Create check so that more than one period or dash will not crash app
            // Check if there are multiple occurrences of periods or dashes
            //string
//            int dashcount1 = LatLong2[0].length() - LatLong2[0].replace("-", "").length();
//            int dashcount2 = LatLong2[1].length() - LatLong2[1].replace("-", "").length();
//            int periodcount1 = LatLong2[0].length() - LatLong2[0].replace(".", "").length();
//            int periodcount2 = LatLong2[1].length() - LatLong2[1].replace(".", "").length();
//
//            if(dashcount1 > 1 || dashcount2 > 1 || periodcount1 > 1 || periodcount2 > 1) {
//                AlertDialog alertDialog = new AlertDialog.Builder(DisplayLatLng.this).create();
//                alertDialog.setTitle("Error");
//                alertDialog.setMessage("Incorrect coordinates");
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                                finish();
//                            }
//                        });
//                alertDialog.show();
//                finish();
//            }

            // This parses the strings in the array to doubles
            double Lat = Double.parseDouble(LatLong2[0]);
            double Lng = Double.parseDouble(LatLong2[1]);
            LatLng location = new LatLng(Lat, Lng);
            mMap.addMarker(new MarkerOptions().position(location).title("The Location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, Zoom));
        } else {
            // Alerts user that coordinates are inputted incorrectly
            AlertDialog alertDialog = new AlertDialog.Builder(DisplayLatLng.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Incorrect coordinates");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            alertDialog.show();
        }
    }
}
