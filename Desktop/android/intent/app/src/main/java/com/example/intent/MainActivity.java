package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final int SEC_ACT_REO_CODE = 2605;
    EditText edt_a, edt_b, edt_c;
    EditText edt_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
        edt_phone = findViewById(R.id.phonenum);

    }

    public void add(View view) {
        float a = Float.parseFloat(edt_a.getText().toString());
        float b = Float.parseFloat(edt_b.getText().toString());
        //float c = Float.parseFloat(edt_c.getText().toString());


        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        startActivityForResult(intent,2605);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode)
        {
            case SEC_ACT_REO_CODE:
                if(resultCode == RESULT_OK){
                    float c = data.getFloatExtra("c", 0);
                    edt_c.setText(String.valueOf(c));
                }
                break;
            default:
                break;
        }

    }

    public void btn_call(View view) {
        String phoneNo = edt_phone.getText().toString();

        Uri number = Uri.parse("tel:"+phoneNo);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void btn_geo(View view) {
        Uri location = Uri.parse("geo:10.762503, 106.682752");
        Intent map = new Intent(Intent.ACTION_VIEW, location);
        startActivity(map);
    }
}


