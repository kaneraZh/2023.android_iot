package com.example.fundamentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;


public class DualActivityAccount extends AppCompatActivity {
    private static class Account {
        private String user;
        private String email;
        private String password;
        public String getUser() {return user;}
        public void setUser(String user) {this.user = user!=null ? user : "invalid";}
        public String getEmail() {return email;}
        public void setEmail(String email) {this.email = email!=null ? email : "invalid";}
        private String getPassword() {return password;}
        public void setPassword(String password) {this.password = password!=null ? password : "invalid";}
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
            new Account("lulu", "lele","lolo"),
            new Account(null, null, null)
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
    private void logout(){
        Intent login = new Intent(this, DualActivityLogin.class);
        startActivity(login);
    }
    public Button btn_logout;
    public void setBtn_logout(Button btn_logout) {
        this.btn_logout = btn_logout;
        this.btn_logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        logout();
                    }
                }
        );
    }
    private static final int[] IMAGES = {
            R.drawable.baseline_person_24,
            R.drawable.sleep,
            R.drawable.baseline_nordic_walking_24,
            R.drawable.baseline_looks_24,
            R.drawable.baseline_surfing_24,
            R.drawable.baseline_pool_24,
    };
    private ImageView image_display;
    public void setImage_display(ImageView image_display) {
        this.image_display = image_display;
        this.image_display.setImageResource(IMAGES[0]);
    }
    public void set_display_image(int id){
        //Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        image_display.setImageResource(IMAGES[id]);
    }
    private static final String[] SPINNER_LIST = {
            "persona",
            "dormir",
            "caminata",
            "arcoiris",
            "surfear",
            "nadar"
    };
    private Spinner spinner_list;
    public void setSpinner_list(Spinner spinner_list) {
        this.spinner_list = spinner_list;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SPINNER_LIST);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner_list.setAdapter(adapter);
        this.spinner_list.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        set_display_image(i);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_account);
        if(getIntent() != null){
            String user = getIntent().getStringExtra("user");
            String password = getIntent().getStringExtra("password");
            setCurrent_user(user, password);
        }
        else {
            logout();
        }
        setImage_display(findViewById(R.id.image_display));
        setDisplay(findViewById(R.id.title));
        setBtn_logout(findViewById(R.id.button_logout));
        setSpinner_list(findViewById(R.id.spinner_options));
    }
}