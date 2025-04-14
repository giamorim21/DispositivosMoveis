package com.example.atividade4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.nome);
        EditText matricula = findViewById(R.id.matricula);
        EditText nota1 = findViewById(R.id.nota1);
        EditText nota2 = findViewById(R.id.nota2);
        Button calcular = findViewById(R.id.button);
        TextView resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeRecebido = nome.getText().toString();
                String matriculaRecebida = matricula.getText().toString();

                double nota1Valor = Double.parseDouble(nota1.getText().toString());
                double nota2Valor = Double.parseDouble(nota2.getText().toString());

                double notaFinal = (nota1Valor * 0.4) + (nota2Valor * 0.6);
                resultado.setText("A nota final do aluno(a) " + nomeRecebido + " da matrícula "+ matriculaRecebida + " foi: " + String.format("%.2f", notaFinal));
            }
        });
    }
}