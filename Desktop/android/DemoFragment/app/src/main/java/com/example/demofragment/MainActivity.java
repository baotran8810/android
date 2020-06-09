package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        intent.putExtra("frag01","This is fragment 01");
        intent.putExtra("frag02","This is fragment 02");
        setIntent(intent);
    }

    public void btn_ok_onclick(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "This is frastion 1", Toast.LENGTH_SHORT);
        toast.show();
    }
}