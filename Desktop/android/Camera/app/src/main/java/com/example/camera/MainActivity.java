package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int REQ_CAM =123;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img_view);
    }

    public void image(View view) {
        Intent image = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(image,REQ_CAM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQ_CAM:
                if(resultCode == RESULT_OK){
                    Bitmap bmp = (Bitmap) data.getExtras().get("data");
                    ImageView img = (ImageView) findViewById(R.id.img_view);
                    img.setImageBitmap(bmp);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
