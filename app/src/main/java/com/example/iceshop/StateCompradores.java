package com.example.iceshop;

import com.example.iceshop.model.Empresa;

public class StateCompradores {
    private static StateCompradores instance;
    public static StateCompradores getInstance(){
        if(instance == null){
            instance = new StateCompradores();
            return instance;
        }
        return instance;
    }

    private Empresa empresa;

    private StateCompradores() {

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

