package com.example.fundamentos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
public class DualActivityLogin extends AppCompatActivity{
    private EditText user;
    private EditText password;
    private Button login;
    public void setUser(EditText user) {
        this.user = user;
    }
    private String get_user(){
        try {
            return this.user.getText().toString();
        }
        catch (Throwable t){
            return "";
        }
    }
    public void setPassword(EditText password) {
        this.password = password;
    }
    private String get_password(){
        try {
            return this.password.getText().toString();
        }
        catch (Throwable t){
            return "";
        }
    }
    public void do_login(String usr, String pwd){
        Intent profile = new Intent(this, DualActivityAccount.class);
    }
    public void setLogin(Button login) {
        this.login = login;
        this.login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        do_login(get_user(), get_password());
                    }
                }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_login);
        setLogin(findViewById(R.id.));
    }
}
