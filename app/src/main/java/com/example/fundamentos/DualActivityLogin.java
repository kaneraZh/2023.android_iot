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
    public static String get_EditText_text(EditText edit_text){
        try {
            return edit_text.getText().toString();
        }
        catch (Throwable t){
            return "";
        }
    }
    private String get_user(){
        return get_EditText_text(this.user);
    }
    public void setPassword(EditText password) {
        this.password = password;
    }
    private String get_password(){
        return get_EditText_text(this.password);
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
        setUser(findViewById(R.id.login_user));
        setPassword(findViewById(R.id.login_password));
        setLogin(findViewById(R.id.login_button));
    }
}
