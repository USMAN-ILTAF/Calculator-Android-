package com.example.numbernest;

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

public class MainActivity extends AppCompatActivity {


    EditText etFirstValue, etSecondValue;
    TextView tvAns;
    Button add, subtract, multiply,divide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etFirstValue = findViewById(R.id.etFirstValue);
        etSecondValue = findViewById(R.id.etSecondValue);

        tvAns = findViewById(R.id.tvAns);
        add = findViewById(R.id.btnAdd);
        subtract = findViewById(R.id.btnSubtract);
        multiply = findViewById(R.id.btnMultiply);
        divide = findViewById(R.id.btnDivide);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double firstValue = Double.parseDouble(etFirstValue.getText().toString());
                    Double secondValue = Double.parseDouble(etSecondValue.getText().toString());

                    Double ans = firstValue + secondValue;
                    if (ans % 1 == 0) {
                        tvAns.setText(etFirstValue.getText().toString() + " + " + etSecondValue.getText().toString() + " = " + ((int) Math.round(ans)));
                    } else {
                        tvAns.setText(etFirstValue.getText().toString() + " + " + etSecondValue.getText().toString() + " = " + ans);
                    }
                } catch (NumberFormatException e) {
                    tvAns.setText("Invalid input. Please enter numbers.");
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double firstValue = Double.parseDouble(etFirstValue.getText().toString());
                    Double secondValue = Double.parseDouble(etSecondValue.getText().toString());

                    Double ans = firstValue - secondValue;
                    if (ans % 1 == 0) {
                        tvAns.setText(etFirstValue.getText().toString() + " - " + etSecondValue.getText().toString() + " = " + ((int) Math.round(ans)));
                    } else {
                        tvAns.setText(etFirstValue.getText().toString() + " - " + etSecondValue.getText().toString() + " = " + ans);
                    }
                } catch (NumberFormatException e) {
                    tvAns.setText("Invalid input. Please enter numbers.");
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double firstValue = Double.parseDouble(etFirstValue.getText().toString());
                    Double secondValue = Double.parseDouble(etSecondValue.getText().toString());

                    Double ans = firstValue * secondValue;
                    if (ans % 1 == 0) {
                        tvAns.setText(etFirstValue.getText().toString() + " x " + etSecondValue.getText().toString() + " = " + ((int) Math.round(ans)));
                    } else {
                        tvAns.setText(etFirstValue.getText().toString() + " x " + etSecondValue.getText().toString() + " = " + ans);
                    }
                } catch (NumberFormatException e) {
                    tvAns.setText("Invalid input. Please enter numbers.");
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double firstValue = Double.parseDouble(etFirstValue.getText().toString());
                    Double secondValue = Double.parseDouble(etSecondValue.getText().toString());

                    if (secondValue == 0) {
                        tvAns.setText("Error: Division by zero is not allowed.");
                        return;
                    }

                    Double ans = firstValue / secondValue;
                    if (ans % 1 == 0) {
                        tvAns.setText(etFirstValue.getText().toString() + " ÷ " + etSecondValue.getText().toString() + " = " + ((int) Math.round(ans)));
                    } else {
                        tvAns.setText(etFirstValue.getText().toString() + " ÷ " + etSecondValue.getText().toString() + " = " + ans);
                    }
                } catch (NumberFormatException e) {
                    tvAns.setText("Invalid input. Please enter numbers.");
                } catch (ArithmeticException e) {
                    tvAns.setText("Error: Division by zero.");
                }
            }
        });



    }



}