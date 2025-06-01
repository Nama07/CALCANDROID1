package com.example.calc;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnFactorial;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnFactorial = findViewById(R.id.btnFactorial);
        resultText = findViewById(R.id.resultText);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnSubtract.setOnClickListener(view -> calculate('-'));
        btnMultiply.setOnClickListener(view -> calculate('*'));
        btnDivide.setOnClickListener(view -> calculate('/'));
        btnFactorial.setOnClickListener(view -> calculateFactorial());
    }

    private void calculate(char op) {
        String val1 = number1.getText().toString();
        String val2 = number2.getText().toString();

        if (val1.isEmpty() || val2.isEmpty()) {
            resultText.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(val1);
        double num2 = Double.parseDouble(val2);
        double result;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultText.setText("Can't divide by zero!");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                resultText.setText("Invalid operation");
                return;
        }

        resultText.setText("Result: " + result);
    }

    private void calculateFactorial() {
        String val = number1.getText().toString();

        if (val.isEmpty()) {
            resultText.setText("Enter a number for factorial");
            return;
        }

        double input = Double.parseDouble(val);

        if (input != (int) input || input < 0 || input > 20) {
            resultText.setText("Enter a whole number between 0 and 20");
            return;
        }

        int num = (int) input;
        long result = 1;

        for (int i = 1; i <= num; i++) {
            result *= i;
        }

        resultText.setText(num + "! = " + result);
    }
}
