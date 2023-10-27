package com.example.fundamentos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.fundamentos.R;
import com.example.fundamentos.dtos.Producto;

public class DetalleActivity extends AppCompatActivity {
    private Producto producto;
    public void setProducto(Producto producto) {
        this.producto = producto;
        this.set_txt_nombre(producto.getNombre());
        this.set_txt_descripcion(producto.getDescripcion());
        this.set_txt_precio(producto.getPrecio());
        this.set_txt_stock(producto.getStock());
    }
    private void producto_actualizar(){
        this.producto.setNombre( this.get_txt_nombre() );
        this.producto.setDescripcion( this.get_txt_descripcion() );
        this.producto.setPrecio( this.get_txt_precio() );
        this.producto.setStock( this.get_txt_stock() );
    }
    private void producto_borrar(){
        
    }

    private EditText txt_nombre;
    private EditText txt_descripcion;
    private EditText txt_precio;
    private EditText txt_stock;
    public void setTxt_nombre(EditText txt_nombre) {this.txt_nombre = txt_nombre;}
    public void setTxt_descripcion(EditText txt_descripcion) {this.txt_descripcion = txt_descripcion;}
    public void setTxt_precio(EditText txt_precio) {this.txt_precio = txt_precio;}
    public void setTxt_stock(EditText txt_stock) {this.txt_stock = txt_stock;}

    public void set_txt_nombre(String nombre){ this.txt_nombre.setText(nombre); }
    public void set_txt_descripcion(String descripcion){ this.txt_descripcion.setText(descripcion); }
    public void set_txt_precio(int precio){ this.txt_precio.setText( String.valueOf(precio) ); }
    public void set_txt_stock(int stock){ this.txt_stock.setText( String.valueOf(stock) ); }
    public String get_txt_nombre(){ return this.txt_nombre.getText().toString(); }
    public String get_txt_descripcion(){ return this.txt_descripcion.getText().toString(); }
    public int get_txt_precio(){ return Integer.valueOf(this.txt_precio.getText().toString()); }
    public int get_txt_stock(){ return Integer.valueOf(this.txt_stock.getText().toString()); }

    private Button btn_borrar;
    private Button btn_actualizar;
    public void setBtn_borrar(Button btn_borrar) {
        this.btn_borrar = btn_borrar;
    }
    public void setBtn_actualizar(Button btn_actualizar) {
        this.btn_actualizar = btn_actualizar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTxt_nombre( findViewById(R.id.text_nombre) );
        setTxt_descripcion( findViewById(R.id.text_descripcion) );
        setTxt_precio( findViewById(R.id.text_precio) );
        setTxt_stock( findViewById(R.id.text_stock) );
        setBtn_borrar( findViewById(R.id.btn_borrar) );
        setBtn_actualizar( findViewById(R.id.btn_actualizar) );

        Producto prod = (Producto) savedInstanceState.getSerializable("producto");
        if( prod != null ){
            setProducto(prod);
        }
        else {
            startActivity( new Intent(this, LoggedUserActivity.class));
        }
    }
}