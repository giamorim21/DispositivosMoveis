package com.example.revisao2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText matricula;
    private Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inicializarTela();
    }

    private void inicializarTela() {
        nome = findViewById(R.id.Nome);
        matricula = findViewById(R.id.Matricula);
        iniciar = findViewById(R.id.Iniciar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passarProxTela();
            }
        });
    }

    private void passarProxTela() {
        Intent proxTela = new Intent(this, SegundaTela.class);

        proxTela.putExtra("chaveNome", nome.getText().toString());
        proxTela.putExtra("chaveMatricula", matricula.getText().toString());

        startActivity(proxTela);
    }

    public void chamaSegundaTela(View view){
        String nomeInformado = nome.getText().toString();
        String matriculaInformada = matricula.getText().toString();

        Intent meuIntent = new Intent(this, SegundaTela.class);

        meuIntent.putExtra("nomeDoUsuario", nomeInformado);
        meuIntent.putExtra("matriculaDoUsuario", matriculaInformada);

        startActivity(meuIntent);
    }
}
