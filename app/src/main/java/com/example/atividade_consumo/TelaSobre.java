package com.example.atividade_consumo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TelaSobre extends AppCompatActivity {

    private View btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}