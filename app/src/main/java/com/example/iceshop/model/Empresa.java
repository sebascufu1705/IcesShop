package com.example.iceshop.model;

import android.graphics.drawable.Drawable;
import android.view.DragEvent;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Empresa implements Serializable {
    private  String nombre;
    private  String codigo;
    private  String nombreEmp;
    private String producto;
    private String url;

    public Empresa(String nombre, String codigo, String nombreEmp, String producto, String url) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreEmp = nombreEmp;
        this.producto = producto;
        this.url = url;
    }

    public Empresa() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return nombreEmp + "\n" + url;
    }
}
