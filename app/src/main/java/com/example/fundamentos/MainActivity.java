package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    EditText input_a;
    public void setInput_a(EditText input_a) {
        this.input_a = input_a;
    }
    EditText input_b;
    public void setInput_b(EditText input_b) {
        this.input_b = input_b;
    }
    enum Operator{
        SUMA,
        RESTA,
        MULTI,
        DIVISION,
        INVALID;
    }
    Operator operator_current;
    public void setOperator_current(Operator operator_current) {
        this.operator_current = operator_current;
    }
    double get_result(){
        double a = Double.parseDouble(input_a.getText().toString());
        double b = Double.parseDouble(input_b.getText().toString());
        switch (operator_current){
            case SUMA:return (a+b);
            case RESTA:return (a-b);
            case MULTI:return (a*b);
            case DIVISION:return (a/b);
            default:
                throw new Error();
        }
    }
    Button operator_sum;
    public void setOperator_sum(Button operator_sum) {
        this.operator_sum = operator_sum;
        this.operator_sum.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setOperator_current(Operator.SUMA);
                    }
                }
        );
    }
    Button operator_res;
    public void setOperator_res(Button operator_res) {
        this.operator_res = operator_res;
        this.operator_res.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setOperator_current(Operator.RESTA);
                    }
                }
        );
    }
    Button operator_mul;
    public void setOperator_mul(Button operator_mul) {
        this.operator_mul = operator_mul;
        this.operator_mul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setOperator_current(Operator.MULTI);
                    }
                }
        );
    }
    Button operator_div;
    public void setOperator_div(Button operator_div) {
        this.operator_div = operator_div;
        this.operator_div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setOperator_current(Operator.DIVISION);
                    }
                }
        );
    }
    TextView display;
    public void setDisplay(TextView display) {
        this.display = display;
    }
    void display_update(){
        String result;
        try {
            result = Double.toString(get_result());
        }
        catch (Throwable t){
            result = "error";
        }
        if(display != null)display.setText(result);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInput_a( findViewById(R.id.input_a) );
        setInput_b( findViewById(R.id.input_b) );
        setOperator_sum( findViewById(R.id.operator_sum) );
        setOperator_res( findViewById(R.id.operator_res) );
        setOperator_mul( findViewById(R.id.operator_mul) );
        setOperator_div( findViewById(R.id.operator_div) );
        setOperator_current( Operator.INVALID );
        setDisplay( findViewById(R.id.result_display) );
    }
}