package com.example.simplecalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    private Double firstValue = null;//keeps first number
    private String pendingOp = null;//stores operations


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

        //get references from UI
        display = findViewById(R.id.tvDisplay);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                display.append("1");
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("2"); }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("3"); }
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("4"); }
        });

        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("5"); }
        });

        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("6"); }
        });

        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("7"); }
        });

        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("8"); }
        });

        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("9"); }
        });

        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { display.append("0"); }
        });

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String txt = display.getText().toString();
                if (txt.isEmpty()) return;
                firstValue = Double.parseDouble(txt);
                pendingOp = "+";
                display.setText("");
            }
        });


        Button btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String txt = display.getText().toString();
                if (txt.isEmpty()) return;
                firstValue = Double.parseDouble(txt);
                pendingOp = "−";
                display.setText("");
            }
        });


        Button btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String txt = display.getText().toString();
                if (txt.isEmpty()) return;
                firstValue = Double.parseDouble(txt);
                pendingOp = "×";
                display.setText("");
            }
        });


        Button btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String txt = display.getText().toString();
                if (txt.isEmpty()) return;
                firstValue = Double.parseDouble(txt);
                pendingOp = "÷";
                display.setText("");
            }
        });


        Button btnEq = findViewById(R.id.btnEq);
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (firstValue == null || pendingOp == null) return;
                String txt = display.getText().toString();
                if (txt.isEmpty()) return;

                double second = Double.parseDouble(txt);
                double result = CalcUtils.calculate(firstValue, second, pendingOp);
                if (Double.isNaN(result)) {
                    display.setText("Cannot Divide by 0");//incase divide by 0
                } else {
                    display.setText(CalcUtils.trim(result));
                }
                firstValue = null;
                pendingOp = null;
            }
        });

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                display.setText("");//clears
                firstValue = null;
                pendingOp = null;
            }
        });

    }

}

/* Note: We used ChatGPT as help for layout and wiring onClick listeners.
        We typed, tested, and take responsibility for the final code. */
