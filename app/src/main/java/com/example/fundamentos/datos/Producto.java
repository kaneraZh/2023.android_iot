package com.example.fundamentos.datos;

public class Producto {
    private String nombre;
    public String getNombre(){return nombre;}
    private int precio;
    public int getPrecio(){return precio;}
    private String descripcion;
    public String getDescripcion(){return descripcion;}
    private int stock;
    public int getStock(){return stock;}
    public Producto(
            String nombre,
            int precio,
            String descripcion,
            int stock
    ){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }
}
