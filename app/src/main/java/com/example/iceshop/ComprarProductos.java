package com.example.iceshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.iceshop.model.Empresa;
import com.example.iceshop.model.Producto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ComprarProductos extends AppCompatActivity {

    private ImageView backBtn;
    private ListView listaComproductos;
    private AdapterComProductos adapter;
    private Empresa empresa;
    private TextView nombreComEmpresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_productos);
        backBtn = findViewById(R.id.backBtn);
        listaComproductos = findViewById(R.id.listaComproductos);
        nombreComEmpresa = findViewById(R.id.nombreComEmpresa);
        adapter = new AdapterComProductos();

        listaComproductos.setAdapter(adapter);

        empresa = LoginState.getInstance().getEmpresa();
        nombreComEmpresa.setText(empresa.getNombreEmp());

        FirebaseDatabase.getInstance().getReference().child("empresas").child(empresa.getNombreEmp()).child("productos")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                long productos = dataSnapshot.getChildrenCount();
                if(productos > 0){
                  //  mensaje.setVisibility(View.GONE);
                }else{
                   // mensaje.setVisibility(View.VISIBLE);
                }
                for (DataSnapshot producto: dataSnapshot.getChildren()
                ) {
                    Producto objetoCom = producto.getValue(Producto.class);
                    adapter.agregarProductoCom(objetoCom);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        backBtn.setOnClickListener(
                (v)->{
                  finish();
                }
        );
        listaComproductos.setOnItemClickListener(
                (view,renglon,pos,id)->{
                    Producto producto = (Producto) adapter.getItem(pos);
                    Intent l = new Intent(this, ComprarProductos.class);
                    startActivity(l);


                }
        );

    }
}
