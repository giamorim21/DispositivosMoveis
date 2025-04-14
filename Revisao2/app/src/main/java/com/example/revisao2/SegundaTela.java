package com.example.revisao2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaTela extends AppCompatActivity {
    private RadioGroup questao1;
    private RadioGroup questao2;
    private Button finalizarProva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela);

        inicializaSegundaTela();
    }

    private void inicializaSegundaTela() {
        questao1 = findViewById(R.id.questao1);
        questao2 = findViewById(R.id.questao2);
        finalizarProva = findViewById(R.id.botaoFinalizarProva);

        finalizarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pontuacao = 0;
                StringBuilder questoesErradas = new StringBuilder();

                int opcaoSelecionada1 = questao1.getCheckedRadioButtonId();
                int opcaoSelecionada2 = questao2.getCheckedRadioButtonId();

                int respostaCorreta1 = R.id.opcaoC;
                int respostaCorreta2 = R.id.opcaoBQuestao2;

                if (opcaoSelecionada1 == respostaCorreta1) {
                    pontuacao += 5;
                } else {
                    questoesErradas.append("Questão 1\n");
                }

                if (opcaoSelecionada2 == respostaCorreta2) {
                    pontuacao += 5;
                } else {
                    questoesErradas.append("Questão 2\n");
                }

                passarUltimaTela(pontuacao, questoesErradas.toString());
            }
        });
    }
    private void passarUltimaTela(int pontuacao, String questoesErradas) {
        Intent ultimaTela = new Intent(this, TerceiraTela.class);
        ultimaTela.putExtra("pontuacao", pontuacao);
        ultimaTela.putExtra("questoesErradas", questoesErradas);

        String nomeDoAluno = getIntent().getStringExtra("chaveNome");
        ultimaTela.putExtra("chaveNome", nomeDoAluno);

        startActivity(ultimaTela);
    }
}
