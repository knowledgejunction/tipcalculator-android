package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDisplayButton();
    }
    public void initDisplayButton(){
        Button button_15 = findViewById(R.id.button15Per);
        Button button_18 = findViewById(R.id.button18Per);
        Button button_20 = findViewById(R.id.button20Per);

        button_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTipAndUpdateText(0.15);
            }
        });
        button_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               calculateTipAndUpdateText(0.18);
            }
        });
        button_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTipAndUpdateText(0.2);
            }
        });

    }

    private void calculateTipAndUpdateText(double percentage) {
        EditText editText = findViewById(R.id.billText);
        String billAmountInText = editText.getText().toString();
        DecimalFormat df = new DecimalFormat("#.00");
        String tip = df.format(Double.parseDouble(billAmountInText) * percentage);
        String outputText = String.format("Tip: $%s, Total Bill: $%s", tip,billAmountInText);
        TextView textView = findViewById(R.id.tipTextView);
        textView.setText(outputText);
    }
}