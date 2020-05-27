package com.example.iceshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iceshop.model.Empresa;
import com.example.iceshop.model.Estudiante;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class inicioActivity extends AppCompatActivity {

    private EditText usuarioIn;
    private EditText passwordIn;
    private Button inicioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        usuarioIn = findViewById(R.id.usuarioIn);
        passwordIn = findViewById(R.id.passwordIn);
        inicioBtn = findViewById(R.id.iniciarBtn);

        inicioBtn.setOnClickListener(
                (v)->{
                    String usuario = usuarioIn.getText().toString();
                    String contraseña = passwordIn.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("usuario").child(usuario).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Estudiante user = dataSnapshot.getValue(Estudiante.class);
                            if(user == null){
                                Toast.makeText(inicioActivity.this, "el usuario no existe", Toast.LENGTH_LONG).show();
                                return;
                            }
                            if(user.getContraseña().equals(contraseña)){
                                //esto es para buscar en las ramas de firebase
                                Query busqueda = FirebaseDatabase.getInstance().getReference().child("empresas")
                                        .orderByChild("codigo").equalTo(user.getCodigo());
                                busqueda.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        for (DataSnapshot coincidencia: dataSnapshot.getChildren()
                                             ) {
                                            Empresa empresa = coincidencia.getValue(Empresa.class);
                                            LoginState.getInstance().setEmpresa(empresa);
                                            break;
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                                Intent i = new Intent(inicioActivity.this, selesccionActivity.class);
                                startActivity(i);
                            //    Toast.makeText(inicioActivity.this,"iniciaste", Toast.LENGTH_LONG).show();
                            }else{
                                //No concuerda la contraseña

                                //Intent i = new Intent(inicioActivity.this, inicioActivity.class);
                                //startActivity(i);
                                Toast.makeText(inicioActivity.this,"El usuario o la contraseña son incorrectos", Toast.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });

                }

        );

    }
}
