package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity3Signin extends AppCompatActivity {
    
    private ImageView icono;
    public void setIcono(ImageView icono) {this.icono = icono;}
//    public String get_icono(){
//        this.icono.
//    }

    private EditText nombre;
    public void setNombre(EditText nombre) {this.nombre = nombre;}
    public String get_nombre(){return this.nombre.getText().toString();}

    static SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    private EditText nacimiento;
    public void setNacimiento(EditText nacimiento) {this.nacimiento = nacimiento;}
    public Boolean verify_nacimiento(Date fecha){return fecha.compareTo(new Date())==0;}
    public String get_nacimiento_str(){
        return this.nacimiento.getText().toString();
    }
    public Date get_nacimiento(){
        date_format.setLenient(false);
        try {
            Date result = date_format.parse(get_nacimiento_str());
            return result;
        }
        catch (ParseException exception){
            return new Date();
        }
    }

    private EditText cargo;
    public void setCargo(EditText cargo) {this.cargo = cargo;}
    public String get_cargo(){return this.cargo.getText().toString();}
    
    private EditText email;
    public void setEmail(EditText email) {this.email = email;}
    public static Boolean verify_email(String email){return email.matches("^(.+)@(\\S+)$");}
    public String get_email(){return this.email.getText().toString();}
    
    private EditText alias;
    public void setAlias(EditText alias) {this.alias = alias;}
    public String get_alias(){return this.alias.getText().toString();}
    
    private EditText telefono;
    public void setTelefono(EditText telefono) {this.telefono = telefono;}
    public Boolean verify_telefono(String telefono){return telefono.matches("^\\d{9}(?![\\s\\S])");}
    public String get_telefono(){return this.telefono.getText().toString();}
    
    private Button btn_signin;
    public void do_signin(){
        String errors = "";
        errors+= verify_email(get_email()) ? "" : "Email es invalido\n";
        errors+= verify_telefono(get_telefono()) ? "" : "Telefono es invalido\n";
        errors+= verify_nacimiento(get_nacimiento()) ? "" : "Fecha de nacimiento es invalida, use formato <dd/mm/aaaa>\n";
        if(errors.equals("")){
            Intent profile = new Intent(this, Activity3Profile.class);
            profile.putExtra("cargo", get_cargo());
            profile.putExtra("email", get_email());
            profile.putExtra("alias", get_alias());
            profile.putExtra("nombre", get_nombre());
            profile.putExtra("telefono", get_telefono());
            profile.putExtra("nacimiento", get_nacimiento_str());
            startActivity(profile);
        }
        else {
            Toast.makeText(this, errors, Toast.LENGTH_SHORT).show();
        }
    }
    public void setBtn_signin(Button btn_signin) {
        this.btn_signin = btn_signin;
        this.btn_signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {do_signin();}
                }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_signin);
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