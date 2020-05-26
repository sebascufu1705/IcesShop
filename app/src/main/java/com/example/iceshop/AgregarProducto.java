package com.example.iceshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iceshop.model.Empresa;
import com.example.iceshop.model.Estudiante;
import com.example.iceshop.model.Producto;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AgregarProducto extends AppCompatActivity {

    private ImageView backBtn;
    private ImageView cancelarBtn;
    private ImageView publicarBtn;
    private EditText imputProducto;
    private EditText imputPrecio;
    private ImageView imgAlfajor;
    private ImageView imgAlfaCho;
    private ImageView imgBrownie;
    private ImageView imgPapas;
    private int fotoSeleccionada;
    private ImageView homeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        backBtn = findViewById(R.id.backBtn);
        cancelarBtn = findViewById(R.id.cancelarBtn);
        publicarBtn = findViewById(R.id.publicarBtn);
        imputProducto = findViewById(R.id.imputProducto);
        imputPrecio = findViewById(R.id.imputPrecio);
        imgAlfajor = findViewById(R.id.imgAlfajor);
        imgAlfaCho = findViewById(R.id.imgAlfaCho);
        imgBrownie = findViewById(R.id.imgBrownie);
        imgPapas = findViewById(R.id.imgPapas);
        homeBtn = findViewById(R.id.homeBtn);


        publicarBtn.setOnClickListener(
                (v) -> {

                    FirebaseDatabase.getInstance().getReference().child("empresas").addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            Empresa empresa = dataSnapshot.getValue(Empresa.class);

                            int url = fotoSeleccionada;
                            String productico = imputProducto.getText().toString();
                            String precio = imputPrecio.getText().toString();

                            Producto producto = new Producto(productico, precio, url);

                            FirebaseDatabase.getInstance().getReference()
                                    .child("empresas").child(empresa.getNombreEmp()).child("productos").child(productico).setValue(producto);
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

                    finish();

                });

        imgAlfajor.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = R.drawable.alfa;
                }
        );

        imgAlfaCho.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = R.drawable.alfacho;
                }
        );

        imgBrownie.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = R.drawable.brownie;
                }
        );

        imgPapas.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = R.drawable.paps;
                }
        );

        cancelarBtn.setOnClickListener(
                (v) -> {
                    finish();
                }
        );

        backBtn.setOnClickListener(
                (v) -> {
                    finish();
                }
        );

        homeBtn.setOnClickListener(
                (v) -> {
                    finish();
                }
        );

    }
}
    /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                      if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                          String[] permisos = {Manifest.permission.READ_EXTERNAL_STORAGE};
                          requestPermissions(permisos,PERMISSION_CODE);
                      }
                      else {
                          pickImageFromGallery();


                      }
                  }
                  else {
                      pickImageFromGallery();

                  }*/

    /*private void pickImageFromGallery(){

        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i, IMAGE_PICK_CODE);

    }*/

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      switch (requestCode){
          case PERMISSION_CODE:{
              if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                  pickImageFromGallery();
              }
              else{
                  Toast.makeText(this,"permiso denegado", Toast.LENGTH_SHORT).show();
              }
          }
      }

    }*/
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            imagenBtn.setImageURI(data.getData());
        }
    }*/

