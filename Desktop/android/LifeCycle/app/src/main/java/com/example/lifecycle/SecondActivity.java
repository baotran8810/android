package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    @Override
    protected void onStart() {
        Log.d("@@@@@@", "onstart2");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("@@@@@@", "onpause2");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("@@@@@@", "onstop2");
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        Log.d("@@@@@@", "onresumePost2");
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        Log.d("@@@@@@", "onDestroy2");
        super.onDestroy();
    }
}
