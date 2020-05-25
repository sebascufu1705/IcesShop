package com.example.iceshop.model;

public class Producto {
    private String nombrePro;
    private String precio;
    private  int foto;

    public Producto() {
    }

    public Producto(String nombrePro, String precio, int foto) {
        this.nombrePro = nombrePro;
        this.precio = precio;
        this.foto = foto;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
