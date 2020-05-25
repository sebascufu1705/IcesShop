package com.example.iceshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class selesccionActivity extends AppCompatActivity {

    private ImageView logoV;
    private ImageView logoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesccion);
        logoV = findViewById(R.id.logovendedor);
        logoC = findViewById(R.id.logocomprador);

        logoV.setOnClickListener(
                (v)->{

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage("¿Ya te registraste como vendedor?");
                    builder.setNegativeButton("No, registrarme", (dialog, which) -> {
                        Intent i = new Intent(selesccionActivity.this,registroVendedores.class);
                        startActivity(i);
                        dialog.dismiss();
                    });
                    builder.setPositiveButton("Si", (dialog, which) -> {
                        finish();
                        Toast.makeText(selesccionActivity.this,"Funciono", Toast.LENGTH_LONG).show();
                    });
                    builder.show();


                }
        );
        logoC.setOnClickListener(
                (v)->{
                    Intent i = new Intent(selesccionActivity.this, HomeCompradorActivity.class);
                    startActivity(i);
                }
        );
    }
}
