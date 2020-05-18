package com.example.iceshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.logoBtn);

        logo.setOnClickListener(
                (v)->{

                    Intent i = new Intent(this,registroActivity.class);
                    startActivity(i);

                }
        );

    }
}
