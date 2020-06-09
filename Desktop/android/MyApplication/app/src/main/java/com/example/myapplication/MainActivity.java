package com.example.myapplication;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Boolean isPlay = false;
    MediaPlayer mediaPlayer;
    Button Play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.em);
        Play = findViewById(R.id.btn_play);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void playOrPause(View view) {

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            Drawable ic_play = getDrawable(android.R.drawable.ic_media_play);
            Play.setBackground(ic_play);
        }
        else{
            Drawable ic_pause = getDrawable(android.R.drawable.ic_media_pause);
            Play.setBackground(ic_pause);
            mediaPlayer.start();
        }

    }
    
}
