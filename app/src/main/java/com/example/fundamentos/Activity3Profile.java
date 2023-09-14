package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;
//import androidmads.library.qrgenearator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity3Profile extends AppCompatActivity {
    public static class Profile{
        public Profile(
                String nombre,
                String nacimiento,
                String alias,
                String cargo,
                String telefono,
                String email) {
            this.nombre = nombre;
            this.nacimiento = nacimiento;
            this.alias = alias;
            this.cargo = cargo;
            this.telefono = telefono;
            this.email = email;
        }

        private String nombre;
        private String nacimiento;
        private String alias;
        private String cargo;
        private String telefono;
        private String email;
        public void setAlias(String alias) {this.alias = alias;}
        public void setCargo(String cargo) {this.cargo = cargo;}
        public void setNombre(String nombre) {this.nombre = nombre;}
        public void setNacimiento(String nacimiento) {this.nacimiento =nacimiento;}
        public void setTelefono(String telefono) {this.telefono = telefono;}
        public void setEmail(String email) {this.email = email;}
        public String getAlias() {return alias;}
        public String getCargo() {return cargo;}
        public String getNombre() {return nombre;}
        public String getNacimiento() {return nacimiento;}
        public String getEdad() {return "21";}
        public String getTelefono() {return telefono;}
        public String getEmail() {return email;}
//        public void getQr() {
//            QRGenerator
//        }
    }
    private Profile profile;
    public void setProfile(Profile profile) {
        this.profile = profile;
        if(this.alias   != null)update_alias();
        if(this.cargo   != null)update_cargo();
        if(this.nombre  != null)update_nombre();
        if(this.edad    != null)update_edad();
        if(this.telefono!= null)update_telefono();
        if(this.email   != null)update_email();
    }

    private TextView titulo;
    public void setTitulo(TextView titulo) {this.titulo = titulo;}

    private ImageView imagen;
    public void setImagen(ImageView imagen) {this.imagen = imagen;}
    
    private TextView alias;
    public void setAlias(TextView alias) {
        this.alias = alias;
        update_alias();
}
    private void update_alias(){
        if(this.alias!=null && this.profile!=null)
            this.alias.setText(this.alias.getText().toString().replace("%alias", this.profile.getAlias()));
    }
    
    private TextView cargo;
    public void setCargo(TextView cargo) {
        this.cargo = cargo;
        update_cargo();
}
    private void update_cargo(){
        if(this.cargo!=null && this.profile!=null)
            this.cargo.setText(this.cargo.getText().toString().replace("%cargo", this.profile.getCargo()));
    }
    
    private TextView nombre;
    public void setNombre(TextView nombre) {
        this.nombre = nombre;
        update_nombre();
}
    private void update_nombre(){
        if(this.nombre!=null && this.profile!=null)
            this.nombre.setText(this.nombre.getText().toString().replace("%nombre", this.profile.getNombre()));
    }
    
    private TextView edad;
    public void setEdad(TextView edad) {
        this.edad = edad;
        update_edad();
}
    private void update_edad(){
        if(this.edad!=null && this.profile!=null)
            this.edad.setText(this.edad.getText().toString().replace("%edad", this.profile.getEdad()));
    }
    
    private TextView telefono;
    public void setTelefono(TextView telefono) {
        this.telefono = telefono;
        update_telefono();
}
    private void update_telefono() {
        if (this.telefono != null && this.profile != null)
            this.telefono.setText(this.telefono.getText().toString().replace("%telefono", this.profile.getTelefono()));
    }
    
    private TextView email;
    public void setEmail(TextView email) {
        this.email = email;
        update_email();
}
    private void update_email(){
        if(this.email!=null && this.profile!=null)
            this.email.setText(this.email.getText().toString().replace("%email", this.profile.getEmail()));
    }
    
    private ImageView qr;
    public void setQr(ImageView qr) {
        this.qr = qr;
    }
    private void do_logout(){
        startActivity(new Intent(this, Activity3Signin.class));
    }
    private Button btn_logout;

    public void setBtn_logout(Button btn_logout) {
        this.btn_logout = btn_logout;
        this.btn_logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {do_logout();}
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        if(i==null) do_logout();
        Profile p = new Profile(
                i.getStringExtra("nombre"),
                i.getStringExtra("nacimiento"),
                i.getStringExtra("alias"),
                i.getStringExtra("cargo"),
                i.getStringExtra("telefono"),
                i.getStringExtra("email")
        );
        setContentView(R.layout.activity_3_profile);
        setProfile(p);
        setTitulo(findViewById(R.id.profile_titulo));
        setImagen(findViewById(R.id.profile_imagen));
        setAlias(findViewById(R.id.profile_alias));
        setCargo(findViewById(R.id.profile_cargo));
        setNombre(findViewById(R.id.profile_nombre));
        setEdad(findViewById(R.id.profile_edad));
        setTelefono(findViewById(R.id.profile_telefono));
        setEmail(findViewById(R.id.profile_email));
        setQr(findViewById(R.id.profile_qr));
        setBtn_logout(findViewById(R.id.btn_logout));
    }
}