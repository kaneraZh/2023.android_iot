package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivityProfile extends AppCompatActivity {
    private TextView titulo;
    private TextView imagen;
    private TextView alias;
    private TextView cargo;
    private TextView nombre;
    private TextView edad;
    private TextView telefono;
    private TextView email;
    private ImageView qr;

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public void setImagen(TextView imagen) {
        this.imagen = imagen;
    }

    public void setAlias(TextView alias) {
        this.alias = alias;
    }

    public void setCargo(TextView cargo) {
        this.cargo = cargo;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public void setEdad(TextView edad) {
        this.edad = edad;
    }

    public void setTelefono(TextView telefono) {
        this.telefono = telefono;
    }

    public void setEmail(TextView email) {
        this.email = email;
    }

    public void setQr(ImageView qr) {
        this.qr = qr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_profile);
        setTitulo(findViewById(R.id.profile_titulo));
        setImagen(findViewById(R.id.profile_imagen));
        setAlias(findViewById(R.id.profile_alias));
        setCargo(findViewById(R.id.profile_cargo));
        setNombre(findViewById(R.id.profile_nombre));
        setEdad(findViewById(R.id.profile_edad));
        setTelefono(findViewById(R.id.profile_telefono));
        setEmail(findViewById(R.id.profile_email));
        setQr(findViewById(R.id.profile_qr));
    }
}