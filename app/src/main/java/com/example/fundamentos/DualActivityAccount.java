package com.example.fundamentos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DualActivityAccount extends AppCompatActivity {
    private static class Account {
        private String user;
        private String email;
        private String password;
        public String getUser() {return user;}
        public void setUser(String user) {this.user = user;}
        public String getEmail() {return email;}
        public void setEmail(String email) {this.email = email;}
        private String getPassword() {return password;}
        public void setPassword(String password) {this.password = password;}
        public Account(String usr, String eml, String pwd) {
            setUser(usr);
            setEmail(eml);
            setPassword(pwd);
        }
        public boolean compare(String user, String password){
            return (getUser().equalsIgnoreCase(user) || getEmail().equalsIgnoreCase(user) ) && getPassword().equals(password);
        }
    }
    private static final Account[] VALID_USERS= {
            new Account("usr", "eml", "pwd"),
            new Account("lulu", "lele","lolo")
    };
    private static Account getAccount(String user, String password){
        for(int i = 0; i<VALID_USERS.length; ++i){
            if(VALID_USERS[i].compare(user, password)){
                return VALID_USERS[i];
            }
        }
        return null;
    }
    private Account current_user;
    public Account getCurrent_user() {return current_user;}
    public void setCurrent_user(String user, String password) {this.current_user = getAccount(user, password);}
    private TextView display;
    public void setDisplay(TextView display) {
        this.display = display;
        this.display.setText("Bienvenid@ "+getCurrent_user().getUser());
    }
    public static boolean login_valid(String user, String password){
        for(int i = 0; i<VALID_USERS.length; ++i){
            if(VALID_USERS[i].compare(user, password)){
                return true;
            }
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_account);
        String user = savedInstanceState.getString("user");
        String password = savedInstanceState.getString("password");
        setCurrent_user(user, password);
        setDisplay(findViewById(R.id.title));
    }
}