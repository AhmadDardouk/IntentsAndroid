package com.example.intents;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;
public class mail extends AppCompatActivity implements View.OnClickListener {
    Button send, back;
    EditText emailText, Users, CC, BCC, Subject;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        send = findViewById(R.id.Send);
        Users = findViewById(R.id.users);
        emailText = findViewById(R.id.Message);
        send.setOnClickListener(this);
        back = findViewById(R.id.Back);
        CC = findViewById(R.id.CC);
        BCC = findViewById(R.id.BCC);
        back.setOnClickListener(this);
        Subject = findViewById(R.id.Subject);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);

    }

    @Override
    public void onClick(View v) {
        if (v == send) {
            if (Users.getText().toString().length() == 0) {
                t1.setText("this field is required");
            }

            if (emailText.getText().toString().length() == 0) {
                t2.setText("this field is required");
            } else {
                t1.setText("");
                t1.setText("");
                StringTokenizer Emails = new StringTokenizer(Users.getText().toString(), ",");
                StringTokenizer ToCC = new StringTokenizer(CC.getText().toString(), ",");
                StringTokenizer ToBCC = new StringTokenizer(BCC.getText().toString(), ",");
                while (Emails.hasMoreElements() || ToBCC.hasMoreElements() || ToCC.hasMoreElements()) {
                    String Email = (String) Emails.nextElement();
//             String CCEmail = (String) ToCC.nextElement();
//             String BCCEmail = (String) ToBCC.nextElement();
                    if (Email.length() > 0) {
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_SUBJECT, Subject.getText().toString());
                        email.putExtra(Intent.EXTRA_TEXT, emailText.getText().toString());
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{Users.getText().toString()});
                        email.putExtra(android.content.Intent.EXTRA_BCC, new String[]{BCC.getText().toString()});
                        email.putExtra(android.content.Intent.EXTRA_CC, new String[]{CC.getText().toString()});
                        email.setType("message/rfc822");
                        startActivity(email);
                    }
                }

            }
        }
        if(v==back)
        {
            onBackPressed();
        }
    }
}

