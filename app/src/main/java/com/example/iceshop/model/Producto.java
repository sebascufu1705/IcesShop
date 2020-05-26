package com.example.iceshop.model;

public class Producto {
    private String nombrePro;
    private String precio;
    private  int url;

    public Producto() {
    }

    public Producto(String nombrePro, String precio, int url) {
        this.nombrePro = nombrePro;
        this.precio = precio;
        this.url = url;
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

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
