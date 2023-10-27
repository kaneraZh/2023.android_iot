package com.example.fundamentos.dtos;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre) {this.nombre = nombre;}

    private String descripcion;
    public String getDescripcion(){ return descripcion; }
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    private int precio;
    public int getPrecio(){ return precio; }
    public void setPrecio(int precio) {this.precio = precio;}

    private int stock;
    public int getStock(){ return stock; }
    public void setStock(int stock) {this.stock = stock;}

    public Producto(
            String nombre,
            String descripcion,
            int precio,
            int stock
    ){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto(){}
}
