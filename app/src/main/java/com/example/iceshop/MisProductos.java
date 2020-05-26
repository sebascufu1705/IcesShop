package com.example.iceshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.iceshop.model.Empresa;
import com.example.iceshop.model.Producto;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
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
        listaProductos.setEmptyView(mensaje);
        listaProductos.setAdapter(adapter);

       FirebaseDatabase.getInstance().getReference().child("empresas").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Empresa empresa = dataSnapshot.getValue(Empresa.class);

                FirebaseDatabase.getInstance().getReference().child("empresa").child(empresa.getNombreEmp()).child("prductos").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Producto producto = dataSnapshot.getValue(Producto.class);

                        adapter.agregarProducto(producto);
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }
                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }
                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
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
