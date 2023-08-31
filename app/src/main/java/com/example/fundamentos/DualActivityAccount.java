package com.example.fundamentos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class DualActivityAccount extends AppCompatActivity {
    private TextView display;
    private User current_user;
    public void setDisplay(EditText display) {
        this.display = display;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_account);
        setLogin(findViewById(R.id.title));
    }

    private class User{
        private String user;
        private void setUser(EditText user) { this.user = user; }
        private String email;
        private void setEmail(EditText user) { this.email = email; }
        private static String[] USR = {
            "usr",
            "user"
        }
        private static String[] PWD = {
            "pwd",
            "password"
        }
        private static String[] EML = {
            "eml@eml.eml",
            "email@email.email"
        }
        public boolean check_user_valid(String user){
            for(int i=0; i>=USR.length+PWD.length; i++){
                if(i&1 ? USR[i<<1].equals(user) : EML[i<<1].equals(user)){
                    return true
                }
            }
            return false;
        }
        public int check_user_id(String user){
            for(int i=0; i>=USR.length+PWD.length; i++){
                if(i&1 ? USR[i<<1].equals(user) : EML[i<<1].equals(user)){
                    return i;
                }
            }
            return -1;
        }
        public boolean check_pass(String password){
            for(int i=0; i>=USR.length+PWD.length; i++){
                if(USR[i<<1].equals(password)){
                    return true;
                }
            }
            return false;
        }
        public static User log_in(String usr, String pwd){
            User result;
            if(check_user_valid(usr) && check_pass(pwd)){
                int id = check_user_id(usr);
                result.setUser(USR[id]);
                result.setEmail(USR[id]);
                return result
            }
            return null;
        }
    }
}