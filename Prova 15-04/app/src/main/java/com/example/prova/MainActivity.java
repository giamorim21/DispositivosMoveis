package com.example.prova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

// Prova dos alunos:
// Giovana Amori Campos
// Felipe Madruga Gusmão

public class MainActivity extends AppCompatActivity {

    private RadioGroup questao1;
    private RadioGroup questao2;
    private RadioGroup questao3;
    private Button botaoFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inicializarTela();
    }

    private void inicializarTela() {

        questao1 = findViewById(R.id.questao1);
        questao2 = findViewById(R.id.questao2);
        questao3 = findViewById(R.id.questao3);
        botaoFinalizar = findViewById(R.id.botao);

        botaoFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarProva();
            }
        });
    }

    private void enviarProva() {
        
        String resposta1 = verificar(questao1);
        String resposta2 = verificar(questao2);
        String resposta3 = verificar(questao3);

       if (resposta1.equals("") || resposta2.equals("") || resposta3.equals("")) {
            Toast.makeText(this, "Por favor, responda todas as questões.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent telaResultado = new Intent(MainActivity.this, SegundaTela.class);

        telaResultado.putExtra("chaveResposta1", resposta1);
        telaResultado.putExtra("chaveResposta2", resposta2);
        telaResultado.putExtra("chaveResposta3", resposta3);

        startActivity(telaResultado);

    }

    private String verificar(RadioGroup questao) {

        int idOpcaoSelecionada = questao.getCheckedRadioButtonId();
        RadioButton radioButtonSelecionado = findViewById(idOpcaoSelecionada);
        if (idOpcaoSelecionada == -1) {
            return "";
        }
        return radioButtonSelecionado.getText().toString();

    }
}