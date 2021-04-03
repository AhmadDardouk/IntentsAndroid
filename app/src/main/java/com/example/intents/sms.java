package com.example.intents;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class sms extends AppCompatActivity implements View.OnClickListener {
    Button send, back;
    EditText inputnumbers,message;
    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        send= findViewById(R.id.SendSms);
        send.setOnClickListener(this);
        Result=findViewById(R.id.result);
        back = findViewById(R.id.Back);
        back.setOnClickListener(this);
        inputnumbers = findViewById(R.id.numbers);
        message = findViewById(R.id.message);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
    if(v==send)
    {
        Intent i;
        StringTokenizer numbers = new StringTokenizer(inputnumbers.getText().toString(), ",");
        if(inputnumbers.getText().toString().length()==0)
        {
            Result.setText("you have to enter at least one recipient to send for");
        }
        else if(message.getText().toString().length()==0)
        {
            Result.setText("you have to enter a message");
        }
        else {
            while (numbers.hasMoreElements()) {
                String number = (String) numbers.nextElement();
                if (number.length() > 0) {
                    i = new Intent(Intent.ACTION_SENDTO);
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 123);
                    } else {
                        String scAddress = null;
                        PendingIntent sentIntent = null, deliveryIntent = null;
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage
                                (number, scAddress, message.getText().toString(),
                                        sentIntent, deliveryIntent);
                    }

                }

            }
            Result.setText("your message has been sent successfuly");

        }
    }
    if(v==back)
    {
      onBackPressed();
    }
    }
}