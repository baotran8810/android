package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        Log.d("@@@@@@", "onstart1");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("@@@@@@", "onpause1");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("@@@@@@", "onstop1");
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        Log.d("@@@@@@", "onresumePost1");
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        Log.d("@@@@@@", "onDestroy1");
        super.onDestroy();
    }

    public void lnlo_onclick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
