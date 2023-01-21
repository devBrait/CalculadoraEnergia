package com.example.atividade_consumo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private View btnSobre;

    private EditText txtPotencia;

    private EditText txtTempo;

    private Button btnResultado;

    double Number1, Number2, Consumo, Conta;

    private TextView txtValor_consumo, txtValor_conta;

    String[] mensagens = {"Preencha todos os campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        btnSobre = findViewById(R.id.btnSobre);
        btnSobre.setOnClickListener(view ->{
                startActivity(new Intent(this, TelaSobre.class));
        });


        btnResultado = findViewById(R.id.btnCalcular);
        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Potencia = txtPotencia.getText().toString();
                String Tempo = txtTempo.getText().toString();
                if(Potencia.isEmpty() || Tempo.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
                else{

                    Number1 = Double.parseDouble(txtPotencia.getText().toString());
                    Number2 = Double.parseDouble(txtTempo.getText().toString());

                    Consumo=(Number1*Number2*30)/1000;

                    Conta = Consumo * 0.50;

                    txtValor_conta.setText(String.valueOf("R$"+" "+ Conta));
                     txtValor_consumo.setText(String.valueOf(Consumo + " "+"Kw/H"));
                }

            }
        });
    }

    private void IniciarComponentes(){

        txtTempo = findViewById(R.id.txtTempo);
        txtPotencia = findViewById(R.id.txtPotencia);
        txtValor_consumo = findViewById(R.id.txtValor_consumo);
        txtValor_conta = findViewById(R.id.txtValor);
    }
}