package com.example.iceshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.iceshop.model.Estudiante;
import com.google.firebase.database.FirebaseDatabase;

public class registroActivity extends AppCompatActivity {

    private EditText usuarioInput;
    private EditText passwordInput;
    private Button registrarBtn;
    private TextView iniciar;
    private EditText codigoEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarioInput= findViewById(R.id.usuarioInput);
        passwordInput = findViewById(R.id.passwordInput);
        registrarBtn = findViewById(R.id.registrarBtn);
        iniciar = findViewById(R.id.irIniciar);
        codigoEstudiante = findViewById(R.id.codigoEstudiante);


        registrarBtn.setOnClickListener(
                (v)->{
                   String id =  FirebaseDatabase.getInstance().getReference()
                            .child("usuario").push().getKey();
                    String usuario = usuarioInput.getText().toString() ;
                    String contraseña = passwordInput.getText().toString();
                    String codigo = codigoEstudiante.getText().toString();

                    Estudiante estudiante = new Estudiante(id,usuario,contraseña,codigo);

                    FirebaseDatabase.getInstance().getReference()
                            .child("usuario").child(usuario).setValue(estudiante);

                    Intent i = new Intent(this,inicioActivity.class);
                    startActivity(i);

                }
        );
        iniciar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(registroActivity.this,inicioActivity.class);
                    startActivity(i);
                }
        );


    }
}
