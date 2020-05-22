package com.example.iceshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.iceshop.model.EmpresaAdapter;

public class HomeCompradorActivity extends AppCompatActivity {

    private ListView listaComidas;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_comprador);

        listaComidas = findViewById(R.id.listaComidas);
        adapter = new CustomAdapter();
        listaComidas.setAdapter(adapter);



        EmpresaAdapter empresa = new EmpresaAdapter(foto, nombre);
        adapter.agregarEmpresa(empresa);
    }
}
