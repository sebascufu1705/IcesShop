package com.example.iceshop;

import com.example.iceshop.model.Empresa;

public class LoginState {

    private static LoginState instance;
    public static LoginState getInstance(){
        if(instance == null){
            instance = new LoginState();
            return instance;
        }
        return instance;
    }

    private Empresa empresa;

    private LoginState() {

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
