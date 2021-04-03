package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView nav=findViewById ( R.id.nav );
        nav.setItemIconTintList ( null );
        nav.setOnNavigationItemSelectedListener (this);
        nav.setClickable ( true );
        nav.setSelected ( true );
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId ()==R.id.SMS)
        { Intent i = new Intent(this,sms.class);

            startActivity(i);
        }

        else if (item.getItemId ()==R.id.map)
        {


            Intent i = new Intent(this,map.class);
            startActivity ( i );
        }


        else if (item.getItemId ()==R.id.mail)
        {

            Intent i = new Intent(this,mail.class);



            startActivity ( i );


        }
        else if (item.getItemId ()==R.id.camera)
        {

            Intent i = new Intent(this,camera.class);



            startActivity ( i );


        }
        return false;
    }
}