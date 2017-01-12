package com.example.reddragonzz.tracker_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RequestLatLng extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.tracker_app.MESSAGE";
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_lat_lng);
    }

    /** Send the Latitude and Longitude to the map */
    public void Send_location(View view) {
        Intent display_map = new Intent(this, DisplayLatLng.class);
        EditText editText = (EditText) findViewById(R.id.LatLngPrompt);
        String LatLng = editText.getText().toString();
        display_map.putExtra(EXTRA_MESSAGE,LatLng);
        startActivity(display_map);
    }
}
