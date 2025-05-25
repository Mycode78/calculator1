package com.example.cl;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber1, edtNumber2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        txtResult = findViewById(R.id.txtResult);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });
    }


    private void calculate(char operator) {
        double number1, number2, result = 0;

        try {
            number1 = Double.parseDouble(edtNumber1.getText().toString());
            number2 = Double.parseDouble(edtNumber2.getText().toString());
        } catch (NumberFormatException e) {
            txtResult.setText("لطفاً عدد معتبر وارد کنید.");
            return;
        }

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if(number2 != 0) {
                    result = number1 / number2;
                } else {
                    txtResult.setText("تقسیم بر صفر امکان‌پذیر نیست!");
                    return;
                }
                break;
        }
        txtResult.setText("نتیجه: " + result);
    }
}
