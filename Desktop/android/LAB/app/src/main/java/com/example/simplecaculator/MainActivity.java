package com.example.simplecaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button add, minus,multi, div;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt_1);
        edt2 = findViewById(R.id.edt_2);
        add = findViewById(R.id.btn_add);
        minus = findViewById(R.id.btn_minus);
        multi = findViewById(R.id.btn_divide);
        div = findViewById(R.id.btn_divide);




    }

    public void onCalc(Operator operator) {
        try {
            String text1 = edt1.getText().toString();
            String text2 = edt2.getText().toString();

            Double a1 = Double.parseDouble(text1);
            Double a2 = Double.parseDouble(text2);

            Double result = 0.0;
            TextView Result;

            switch (operator) {
                case add:
                    result = a1 + a2;
                    break;

                case div:
                    result = a1 / a2;
                    break;

                case mul:
                    result = a1 * a2;
                    break;
                case minus:
                    result = a1 - a2;
                    break;

            }
            Result = findViewById(R.id.txt_result);
            Result.setText(result.toString());
        }catch (Exception e){
            Log.e("@@@",e.toString());
            Toast.makeText(context, e.toString() , Toast.LENGTH_LONG).show();
        }

    }

    public void onAdd(View view) {

        onCalc(Operator.add);

    }

    public void onMinus(View view) {
        onCalc(Operator.minus);
    }

    public void onMu(View view) {
        onCalc(Operator.mul);
    }

    public void onDiv(View view) {
        onCalc((Operator.div));

    }
}
