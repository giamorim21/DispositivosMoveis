package com.example.prova;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaTela extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela);

        inicializarSegundaTela();

    }

    private void inicializarSegundaTela() {
        resultado = findViewById(R.id.resultado);
        int notaFinal = calculaNota();
        if (notaFinal == 10) {
            resultado.setText("Você acertou todas as questões. \nVocê tirou 10.");
        } else if (notaFinal == 6) {
            resultado.setText("Você acertou 2 questões.\nVocê tirou 6.");
        } else if (notaFinal == 3) {
            resultado.setText("Você acertou 1 questão. \nVocê tirou 3.");
        } else {
            resultado.setText("Você não acertou nenhuma questão.\nVocê tirou 0.");
        }
    }

    private int calculaNota() {
        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        String resposta3 = getIntent().getStringExtra("chaveResposta3");

        if (resposta1.equals("Verdadeiro") && resposta2.equals("Verdadeiro") && resposta3.equals("Falso")) {
            return 10;
        } else if (resposta1.equals("Verdadeiro") && resposta2.equals("Verdadeiro") || resposta1.equals("Verdadeira") && resposta3.equals("Falso") || resposta2.equals("Verdadeiro") && resposta3.equals("Falso")) {
            return 6;
        } else if (resposta1.equals("Verdadeiro") || resposta2.equals("Verdadeiro") || resposta3.equals("Falso")){
            return 3;
        } else {
            return 0;
        }
    }
}