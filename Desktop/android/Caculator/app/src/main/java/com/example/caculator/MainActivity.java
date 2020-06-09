package com.example.caculator;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    TextView text1;
    boolean isActivate = false;
    boolean dot = false;
    boolean isActivate1 = false;
    int num = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.textView1);




    }

    public void del(View view) {
        String tx1 ="0";
        text1.setText(tx1);
        isActivate = false;
        isActivate1 = false;
        dot = false;


    }

    public Double cacula(String tx1){
        int num =0;
        int rem = 0;
        Double a = 0.0;
        Double b = 0.0;
        String ch = "";

        for (int i = 1; i < tx1.length(); i++) {
            if (tx1.charAt(i) == '+' || tx1.charAt(i) == '-' || tx1.charAt(i) == '*' || tx1.charAt(i) == '/') {
                ch = String.valueOf(tx1.charAt(i));
                num = i;
                break;
            }
        }


        if(tx1.charAt(num+1) =='-' && ch =="-"){
            tx1 =  tx1.substring(0,num+1) + tx1.substring(num+2, tx1.length());
            rem = 1;
        }


        if (ch.equals("+")) {
            String[] output = tx1.split("\\+");

            if(!output[0].isEmpty()){
                a = Double.parseDouble(output[0]);
            }
            if(!output[1].isEmpty()){
                b = Double.parseDouble(output[1]);
            }
            tx1 = String.valueOf(a + b);

        }

        if (ch.equals("-")) {
            String[] output = tx1.split("-");
            String output0 = tx1.substring(0,num);
            String output1 = tx1.substring(num+1, tx1.length());
            a = Double.parseDouble(output0);
            b = Double.parseDouble(output1);
            if (rem == 1) {
                tx1 = String.valueOf(a + b);
            }
            else {
                tx1 = String.valueOf(a - b);
            }


        }
        if (ch.equals("*")) {
            String[] output = tx1.split("\\*");
            if(!output[0].isEmpty()){
                a = Double.parseDouble(output[0]);
            }
            if(!output[1].isEmpty()){
                b = Double.parseDouble(output[1]);
            }
            tx1 = String.valueOf(a * b);

        }
        if (ch.equals("/")) {
            String[] output = tx1.split("/");
            if(!output[0].isEmpty()){
                a = Double.parseDouble(output[0]);
            }
            if(!output[1].isEmpty()){
                b = Double.parseDouble(output[1]);
            }
            if (b == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Can not divide!! Please try other number!!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                tx1 = String.valueOf(a / b);
            }
        }
        

        double rate = Double.parseDouble(tx1);
        Double result =(Math.ceil(rate * 1000) / 1000);
        return result;
    }

    public void add_Text(View view) {
        try {
            String tx1 = (String) text1.getText();
            if (tx1.equals("0")) {
                tx1 = "";
            }
            Button b = (Button) view;
            String text = b.getText().toString();
            if(text.equals("=")){
                text ="";
                tx1 = String.valueOf(cacula(tx1));
                isActivate = false;
                isActivate1 = false;
                dot =false ;
                num =0;
                if(tx1.indexOf(".") != -1)
                {
                    dot =true;
                }
            }

            if(text.equals(".")){
                if(dot == false){
                    tx1 = tx1 + text;
                    dot = true;
                    text ="";
                }
                else{
                    text = "";
                }
            }

            if(text.equals("+") ||  text.equals("-")  ||  text.equals("*") || text.equals("/")){
                if(isActivate == false){
                    tx1 = tx1 + text;
                    isActivate = true;
                    dot = false;
                }
                else{
                    if(tx1.charAt(tx1.length()-1) == '+' || tx1.charAt(tx1.length()-1) == '-'||tx1.charAt(tx1.length()-1) == '*' || tx1.charAt(tx1.length()-1) == '/'){
                        if (text.equals("+")||text.equals("-")){
                            if(isActivate1 == false) {
                                tx1 = tx1 + text;
                            }
                            else {

                            }
                        }
                    }
                    else {
                        tx1 = String.valueOf(cacula(tx1));
                        tx1 = tx1 + text;
                        dot = false;
                    }
                }
            } else {

                tx1 = tx1 + text;

            }
            text1.setText(tx1);
        }catch(Exception e) {
            System.out.println("Error " + e.getMessage());
            Toast toast = Toast.makeText(getApplicationContext(), "Phep tinh khong hop le! Vui long nhap lai", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void back(View view) {
        String tx1 = (String) text1.getText();
        if(tx1.charAt(tx1.length()-1) =='.'){
            dot=false;
        }
        tx1 = tx1.substring(0, tx1.length()-1);
        text1.setText(tx1);
    }
}
