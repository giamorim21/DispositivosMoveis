package com.example.atividade5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// modificadores de aceso no java:
// valem para métodos e para atributos
// - public: pode ser acessado por qualquer classe em qualquer pacote
// - private: pode ser acessado apenad dentro da classe que está definido
// - protected: pode ser acessado por qualquer classe, porém dentro do mesmo pacote, e por subclasses
// - sem nada (default): pode ser acessado apenas por classes no mesmo pacote

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText matricula;
    private EditText nota1;
    private EditText nota2;
    private Button botaoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inicializaTela();
    }

    public void inicializaTela(){
        nome = findViewById(R.id.nome);
        matricula = findViewById(R.id.matricula);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        botaoCalcular = findViewById(R.id.button);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaProximaTela();
            }
        });
    }

    private void chamaProximaTela() {
        Intent proximaTela = new Intent(this, SegundaTela.class);

        proximaTela.putExtra("chaveNome", nome.getText().toString());
        proximaTela.putExtra("chaveMatricula", matricula.getText().toString());
        proximaTela.putExtra("chaveNota1", nota1.getText().toString());
        proximaTela.putExtra("chaveNota2", nota2.getText().toString());

        startActivity(proximaTela);
    }

}

