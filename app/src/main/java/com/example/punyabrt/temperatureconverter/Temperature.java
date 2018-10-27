package com.example.punyabrt.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class Temperature extends AppCompatActivity {

    private static DecimalFormat f2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);


            Button Cel = findViewById(R.id.Celsius_button);
            Button Fah = findViewById(R.id.Fahrenheit_button);
            final TextView Anser = findViewById(R.id.ans_textView);
            final EditText input = findViewById(R.id.int_editText);

            Cel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Num = input.getText().toString();

                    if(Num.isEmpty()) {
                        Int_Alert();
                    }
                    else {
                        Double input = Double.valueOf(Num);
                        Anser.setText(Cel_Fah(input));
                    }
                }
            });

            Fah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Num = input.getText().toString();

                    if(Num.isEmpty()) {
                        Int_Alert();
                    }
                    else {
                        Double input = Double.valueOf(Num);
                        Anser.setText(Fah_Cel(input));
                    }
                }
            });

        }

        public String Cel_Fah(Double input){
            return f2.format(input*1.8+32.0);
        }

        public String Fah_Cel(Double input){
            return f2.format((input-32.0)/1.8);
        }
        public void Int_Alert(){
            Toast t = Toast.makeText(getApplicationContext(), R.string.app_name, Toast.LENGTH_LONG);
            t.show();
        }
    }



