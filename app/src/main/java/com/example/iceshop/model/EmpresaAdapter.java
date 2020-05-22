package com.example.iceshop.model;

import android.widget.ImageView;

public class EmpresaAdapter {

    private String fotoEmpresa;
    private String nombreEmpresa;

    public EmpresaAdapter(String fotoEmpresa, String nombreEmpresa) {
        this.fotoEmpresa = fotoEmpresa;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFotoEmpresa() {
        return fotoEmpresa;
    }

    public void setFotoEmpresa(String fotoEmpresa) {
        this.fotoEmpresa = fotoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
