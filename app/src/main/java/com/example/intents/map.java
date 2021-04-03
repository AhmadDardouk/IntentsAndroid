package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class map extends AppCompatActivity implements View.OnClickListener {
Button search,back;
EditText place,longitude,latidute;
TextView warn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        search = findViewById(R.id.Search);
        back = findViewById(R.id.Back);
        place = findViewById(R.id.Place);
        longitude = findViewById(R.id.Longitude);
        latidute = findViewById(R.id.Latitude);
        search.setOnClickListener(this);
        back.setOnClickListener(this);
        warn=findViewById(R.id.warn);
    }

    @Override
    public void onClick(View v) {

        if (v == search) {

                if (place.getText().toString().length() != 0 && (longitude.getText().toString().length() != 0 && latidute.getText().toString().length() != 0)) {
                    setContentView(R.layout.map);
                    Uri location = Uri.parse("geo:" + latidute.getText().toString() + "," + longitude.getText().toString() + "?q=" + place.getText().toString());
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    i.setPackage("com.google.android.apps.maps");
                    startActivity(i);

                }
                 if (place.getText().toString().length() != 0 && (longitude.getText().toString().length() == 0 && latidute.getText().toString().length() == 0)) {
                    setContentView(R.layout.map);
                    Uri location = Uri.parse("geo:0,0?q=" + place.getText().toString());
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    i.setPackage("com.google.android.apps.maps");
                    startActivity(i);

                }  if (place.getText().toString().length() == 0 && (longitude.getText().toString().length() != 0 && latidute.getText().toString().length() != 0)) {
                    setContentView(R.layout.map);
                    Uri location = Uri.parse("geo:"+latidute.getText().toString()+","+longitude.getText().toString());
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    i.setPackage("com.google.android.apps.maps");
                        startActivity(i);

                }  if ((latidute.getText().toString().length() != 0 && longitude.getText().toString().length() == 0) || (longitude.getText().toString().length() != 0 && latidute.getText().toString().length() == 0)) {
                    warn.setText("Check Longitude and Latidute values");
                }
            }
        if(v==back)
        {
            onBackPressed();
        }
        }
    }
