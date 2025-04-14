package com.example.atividade2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.editTextText);
        EditText senha = findViewById(R.id.editTextText2);
        Button ok = findViewById(R.id.button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nome.getText().toString().equals("admin") && senha.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login efetuado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
