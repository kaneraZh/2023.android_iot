package com.example.fundamentos.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fundamentos.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button login;
    public void setLogin(Button login) {
        this.login = login;
        this.login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {firebase_login_test(get_user(), get_password());}
                }
        );
    }
    EditText user;
    public void setUser(EditText user) {this.user = user;}
    EditText password;
    public void setPassword(EditText password) { this.password = password; }
    private String get_user(){ return this.user.getText().toString(); }
    private String get_password(){ return this.password.getText().toString(); }
    public void firebase_login_test(String user, String password){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(user, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String texto = FirebaseAuth.getInstance().getCurrentUser()!=null ? "si funciono :D" : "no funciono";
//                        Log.e("hola", "onComplete: "+user+password, null);
                        Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
                    }
                }
            );
    }
    public void firebase_login(String user, String password){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(user, password);
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if( task.isSuccessful() ) {
//
//                                }
//                            }
//                        }
//                );
        firebase_login();
    }
    public void firebase_login(){
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            Log.e(null, "firebase_login: user found (" + FirebaseAuth.getInstance().getCurrentUser().getEmail().toString() + ")");
            startActivity( new Intent(this, LoggedUserActivity.class) );
        }
        else {
            Log.e(null, "firebase_login: user not found");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLogin( findViewById(R.id.btn_login));
        setUser( findViewById(R.id.input_correo));
        setPassword( findViewById(R.id.input_clave));
        firebase_login();
    }
}