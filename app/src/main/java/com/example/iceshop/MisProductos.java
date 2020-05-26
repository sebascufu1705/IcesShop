package com.example.iceshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.iceshop.model.Empresa;
import com.example.iceshop.model.Producto;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MisProductos extends AppCompatActivity {

    private ImageView flechaAtrasMP;
    private ImageView agregarProductoBtn;
    private ListView listaProductos;
    private adapterProductos adapter;
    private ImageView mensaje;
    private Empresa empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_productos);

        flechaAtrasMP = findViewById(R.id.flechaAtrasMP);
        agregarProductoBtn = findViewById(R.id.agregarProductoBtn);
        listaProductos = findViewById(R.id.listaProductos);
        mensaje = findViewById(R.id.mensaje);

        adapter = new adapterProductos();
       // listaProductos.setEmptyView(mensaje);
        listaProductos.setAdapter(adapter);

        empresa = LoginState.getInstance().getEmpresa();

        FirebaseDatabase.getInstance().getReference().child("empresas").child(empresa.getNombreEmp()).child("productos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adapter.clear();
                long productos = dataSnapshot.getChildrenCount();
                if(productos > 0){
                    mensaje.setVisibility(View.GONE);
                }else{
                    mensaje.setVisibility(View.VISIBLE);
                }
                for (DataSnapshot producto: dataSnapshot.getChildren()
                     ) {
                    Producto objeto = producto.getValue(Producto.class);
                    objeto.setUrl(R.drawable.diems);
                    adapter.agregarProducto(objeto);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        agregarProductoBtn.setOnClickListener(
                (v)->{
                    Intent g = new Intent(MisProductos.this, AgregarProducto.class);
                    startActivity(g);

                }
        );
    }
}
