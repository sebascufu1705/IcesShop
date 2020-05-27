package com.example.iceshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PedirProductos extends AppCompatActivity {

    private TextView nombrePro;
    private ImageView fotoPro;
    private TextView precioPro;
    private EditText cantidadIn;
    private EditText salonIn;
    private ImageView pedirBtn;
    private  ImageView backPedirBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_productos);
        nombrePro = findViewById(R.id.nombrePro);
        fotoPro = findViewById(R.id.fotoPro);
        precioPro = findViewById(R.id.precioPro);
        cantidadIn = findViewById(R.id.cantidadIn);
        salonIn = findViewById(R.id.salonIn);
        pedirBtn = findViewById(R.id.pedirBtn);
        backPedirBtn = findViewById(R.id.backPedirBtn);


        String nombreProducto = getIntent().getExtras().get("nombreProducto").toString();
        String precioProducto = getIntent().getExtras().get("precioProducto").toString();
        int fotografia = (int)getIntent().getExtras().get("fotoPro");


        nombrePro.setText(nombreProducto);
        precioPro.setText(precioProducto);
        fotoPro.setImageResource(fotografia);

        String cantidad = cantidadIn.getText().toString();
        String salon = salonIn.getText().toString();
        pedirBtn.setOnClickListener(
                (v)->{

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage("Tu pedido ha sido realizado");
                    builder.setNegativeButton("Cancelar", (dialog, which) -> {
                       dialog.dismiss();
                    });
                    builder.setPositiveButton("Seguir Comprando", (dialog, which) -> {
                    finish();
                    });
                    builder.show();

                }
        );

//boton de regresar
        backPedirBtn.setOnClickListener(
                (v)->{
                    finish();
                }

        );
    }

}
