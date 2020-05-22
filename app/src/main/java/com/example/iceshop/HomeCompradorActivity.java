package com.example.iceshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.iceshop.model.Empresa;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeCompradorActivity extends AppCompatActivity {

    private ListView listaComidas;
    private ArrayAdapter<Empresa> adapter;
    private ArrayList<Empresa> comidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_comprador);

        listaComidas = findViewById(R.id.listaComidas);
        comidas = new ArrayList<Empresa>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas);
        listaComidas.setAdapter(adapter);

        FirebaseDatabase.getInstance().getReference().child("empresas").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Empresa empresa = dataSnapshot.getValue(Empresa.class);
                comidas.add(empresa);
                adapter.notifyDataSetChanged();
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
}
