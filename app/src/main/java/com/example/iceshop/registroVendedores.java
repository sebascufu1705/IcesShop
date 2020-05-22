package com.example.iceshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.iceshop.model.Empresa;
import com.google.firebase.database.FirebaseDatabase;

public class registroVendedores extends AppCompatActivity {

    private EditText nameStu;
    private EditText code;
    private EditText nameEmp;
    private EditText product;
    private Button RegistrarEmpresaBtn;
    private ImageView imgDiems, imgLocuritas, imgSgrDaddies, imgNams, imgPerritos, imgLelePops;

    private String fotoSeleccionada = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vendedores);

        nameStu = findViewById(R.id.nameStu);
        code = findViewById(R.id.code);
        nameEmp = findViewById(R.id.nameEmp);
        product = findViewById(R.id.product);
        RegistrarEmpresaBtn = findViewById(R.id.RegistrarEmpresaBtn);
        imgDiems = findViewById(R.id.imgDiems);
        imgLelePops = findViewById(R.id.imgLelePops);
        imgPerritos = findViewById(R.id.imgPerritos);
        imgNams = findViewById(R.id.imgNams);
        imgSgrDaddies = findViewById(R.id.imgSgrDaddies);
        imgLocuritas = findViewById(R.id.imgLocuritas);



        RegistrarEmpresaBtn.setOnClickListener(
                (v)->{

                   // String empresa =  FirebaseDatabase.getInstance().getReference()
                        //    .child("empresa").push().getKey();
                    String nombre = nameStu.getText().toString();
                    String codigo = code.getText().toString();
                    String nombreEmp = nameEmp.getText().toString();
                    String producto = product.getText().toString();

                    Empresa empresita = new Empresa(nombre,codigo,nombreEmp,producto);

                    FirebaseDatabase.getInstance().getReference()
                            .child("empresas").child(nombreEmp).setValue(empresita);

                }
        );

        imgDiems.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = "@drawable/diems";
                }
        );

        imgLocuritas.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = "@drawable/diems";
                }
        );

        imgLelePops.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = "@drawable/diems";
                }
        );

        imgSgrDaddies.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = "@drawable/diems";
                }
        );

        imgNams.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = "@drawable/diems";
                }
        );

        imgPerritos.setOnClickListener(
                (v) -> {
                    fotoSeleccionada = "@drawable/diems";
                }
        );
    }
}
