package com.example.demo_file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("@@@@@",getFilesDir().getAbsolutePath());
        Log.d("@@@@@",getFilesDir().getName());
        Log.d("@@@@@",getFilesDir().getParent());
        edt = findViewById(R.id.text1);

    }

    public void Load(View view) {
    }

    public void Save(View view) {
    }
}
