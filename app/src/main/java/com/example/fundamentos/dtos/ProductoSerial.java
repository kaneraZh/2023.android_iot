package com.example.fundamentos.dtos;

import java.io.Serializable;
public class ProductoSerial implements Serializable {
    private String nombre;
    public String getNombre(){ return nombre; }

    private String descripcion;
    public String getDescripcion(){ return descripcion; }

    private int precio;
    public int getPrecio(){ return precio; }

    private int stock;
    public int getStock(){ return stock; }

}
