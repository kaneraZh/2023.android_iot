package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivitySignin extends AppCompatActivity {
    private ImageView icono;
    private EditText nombre;
    private EditText nacimiento;
    private EditText cargo;
    private EditText email;
    private EditText alias;
    private EditText telefono;
    private Button btn_login;

    public void setIcono(ImageView icono) {
        this.icono = icono;
    }

    public void setNombre(EditText nombre) {
        this.nombre = nombre;
    }

    public void setNacimiento(EditText nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setCargo(EditText cargo) {
        this.cargo = cargo;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }

    public void setAlias(EditText alias) {
        this.alias = alias;
    }

    public void setTelefono(EditText telefono) {
        this.telefono = telefono;
    }

    public void setBtn_login(Button btn_login) {
        this.btn_login = btn_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIcono(findViewById(R.id.profile_icono));
        setNombre(findViewById(R.id.profile_nombre));
        setNacimiento(findViewById(R.id.profile_nacimiento));
        setCargo(findViewById(R.id.profile_cargo));
        setEmail(findViewById(R.id.profile_email));
        setAlias(findViewById(R.id.profile_alias));
        setTelefono(findViewById(R.id.profile_telefono));
        setBtn_login(findViewById(R.id.btn_login));
    }
}