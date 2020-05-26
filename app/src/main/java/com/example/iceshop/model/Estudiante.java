package com.example.iceshop.model;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String id;
    private String usuario;
    private String contraseña;
    private String codigo;

    public Estudiante() {
    }

    public Estudiante(String id, String usuario, String contraseña, String codigo) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
