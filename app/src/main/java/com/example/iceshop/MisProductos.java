package com.example.iceshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.FirebaseDatabase;

public class MisProductos extends AppCompatActivity {

    private ImageView flechaAtrasMP;
    private ImageView agregarProductoBtn;
    private ListView listaProductos;
    private adapterProductos adapter;
    private ImageView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_productos);

        flechaAtrasMP = findViewById(R.id.flechaAtrasMP);
        agregarProductoBtn = findViewById(R.id.agregarProductoBtn);
        listaProductos = findViewById(R.id.listaProductos);
        mensaje = findViewById(R.id.mensaje);

        adapter = new adapterProductos();
        listaProductos.setAdapter(adapter);


        listaProductos.setEmptyView(mensaje);


        agregarProductoBtn.setOnClickListener(
                (v)->{
                    Intent g = new Intent(MisProductos.this, AgregarProducto.class);
                    startActivity(g);
                }
        );
    }
}
