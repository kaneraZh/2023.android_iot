package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Date;

public class SecondActivitySignin extends AppCompatActivity {
    private ImageView icono;
    private EditText nombre;
    private EditText nacimiento;
    private EditText cargo;
    private EditText email;
    private EditText alias;
    private EditText telefono;
    private Button btn_signin;
    public void setIcono(ImageView icono) {this.icono = icono;}
    public void setNombre(EditText nombre) {this.nombre = nombre;}
    public String get_nombre(){return this.nombre.getText().toString();}
    public void setNacimiento(EditText nacimiento) {this.nacimiento = nacimiento;}
    public void setCargo(EditText cargo) {this.cargo = cargo;}
    public void setEmail(EditText email) {this.email = email;}
    public void setAlias(EditText alias) {this.alias = alias;}
    public void setTelefono(EditText telefono) {this.telefono = telefono;}
    public void setBtn_signin(Button btn_signin) {this.btn_signin = btn_signin;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_signin);
        setIcono(findViewById(R.id.profile_icono));
        setNombre(findViewById(R.id.profile_nombre));
        setNacimiento(findViewById(R.id.profile_nacimiento));
        setCargo(findViewById(R.id.profile_cargo));
        setEmail(findViewById(R.id.profile_email));
        setAlias(findViewById(R.id.profile_alias));
        setTelefono(findViewById(R.id.profile_telefono));
        setBtn_signin(findViewById(R.id.btn_signin));
    }
}