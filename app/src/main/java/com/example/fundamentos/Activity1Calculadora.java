package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity1Calculadora extends AppCompatActivity {
    EditText input_a;
    public void setInput_a(EditText input_a) {
        this.input_a = input_a;
        this.input_a.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                    @Override
                    public void afterTextChanged(Editable editable) {
                        display_update();
                    }
                }
        );
        display_update();
    }
    EditText input_b;
    public void setInput_b(EditText input_b) {
        this.input_b = input_b;
        this.input_b.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        display_update();
                    }
                }
        );
        display_update();
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
        display_update();
    }
    double get_result(){
        String text_a = input_a.getText().toString();
        String text_b = input_b.getText().toString();
        double a = Double.parseDouble(text_a.isEmpty() ? "0.0" : text_a);
        double b = Double.parseDouble(text_b.isEmpty() ? "0.0" : text_b);
        switch (operator_current){
            case SUMA:return (a+b);
            case RESTA:return (a-b);
            case MULTI:return (a*b);
            case DIVISION:return (a/b);
            default:
                throw new Error();
        }
    }
    TextView display;
    public void setDisplay(TextView display) { this.display = display; }
    void display_update(){
        String result;
        try { result = Double.toString(get_result()); }
        catch (Throwable t){ result = "error"; }
        if(display != null) display.setText(result);
    }
    Button operator_sum;
    public void setOperator_sum(Button operator_sum) {
        this.operator_sum = operator_sum;
        this.operator_sum.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { setOperator_current(Operator.SUMA); }
                }
        );
    }
    Button operator_res;
    public void setOperator_res(Button operator_res) {
        this.operator_res = operator_res;
        this.operator_res.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { setOperator_current(Operator.RESTA); }
                }
        );
    }
    Button operator_mul;
    public void setOperator_mul(Button operator_mul) {
        this.operator_mul = operator_mul;
        this.operator_mul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { setOperator_current(Operator.MULTI); }
                }
        );
    }
    Button operator_div;
    public void setOperator_div(Button operator_div) {
        this.operator_div = operator_div;
        this.operator_div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { setOperator_current(Operator.DIVISION); }
                }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_calculadora);
        setDisplay( findViewById(R.id.result_display) );
        setInput_a( findViewById(R.id.input_a) );
        setInput_b( findViewById(R.id.input_b) );
        setOperator_sum( findViewById(R.id.operator_sum) );
        setOperator_res( findViewById(R.id.operator_res) );
        setOperator_mul( findViewById(R.id.operator_mul) );
        setOperator_div( findViewById(R.id.operator_div) );
        setOperator_current( Operator.INVALID );
        operator_sum.performClick();
    }
}