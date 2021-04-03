package com.example.intents;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class camera extends AppCompatActivity implements View.OnClickListener {
    public static final int cameracode1= 1;
    public static final int cameracode2 = 2;
    ImageView taken;
    Button Pic,Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        taken = findViewById(R.id.IV);
        Pic = findViewById(R.id.cam);
        Back=findViewById(R.id.back);
        Pic.setOnClickListener(this);
        Back.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == cameracode1){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            }else {
                Toast.makeText(this, "Camera Permision is Required", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void openCamera(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,cameracode2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == cameracode2) {
            Bitmap image=(Bitmap) data.getExtras().get("data");
            taken.setImageBitmap(image);
        }
    }

    @Override
    public void onClick(View v) {
        if(v==Pic)
        {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,cameracode2);

        }
        if(v==Back)
        {
            onBackPressed();
        }
    }
}