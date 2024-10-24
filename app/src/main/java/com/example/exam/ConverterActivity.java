package com.example.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConverterActivity extends AppCompatActivity {
    EditText editFeet, editInches;
    Button btnConvert;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_converter);

        editFeet = findViewById(R.id.editFeet);
        editInches = findViewById(R.id.editInches);
        btnConvert = findViewById(R.id.btnConvert);
        result = findViewById(R.id.result);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertToCentimeters();
            }
        });
    }


    public void convertToCentimeters() {
        String feetInput = editFeet.getText().toString();
        String inchesInput = editInches.getText().toString();

        if (!feetInput.isEmpty() && !inchesInput.isEmpty()) {
            double feet = Double.parseDouble(feetInput);
            double inches = Double.parseDouble(inchesInput);

            double inchesToCm = inches * 2.54;
            double feetToCm = feet * 30.48;

            result.setText(String.format("Inches to Centimeters: %.2f cm\nFeet to Centimeters: %.2f cm", inchesToCm, feetToCm));
        } else {
            result.setText("This field Can't be empty, please enter both feet and inches.");
        }
    }
}