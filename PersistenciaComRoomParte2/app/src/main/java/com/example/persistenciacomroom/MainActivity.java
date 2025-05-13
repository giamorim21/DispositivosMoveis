package com.example.persistenciacomroom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText senha;
    private Button cadastrar;
    private MyDatabase db;
    private ListView agendaUsuarios;

    @SuppressLint("MissingInflatedId")
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

        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        cadastrar = findViewById(R.id.cadastrar);
        db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "mydatabase.db").build();
        agendaUsuarios = findViewById(R.id.agendaUsuarios);
        
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        String loginInformado = login.getText().toString();
        String senhaInformado = senha.getText().toString();

        Usuario usuarioAtual = new Usuario(0, loginInformado, senhaInformado);

        //usuarioAtual.login = loginInformado;
        //usuarioAtual.senha = senhaInformado;
        //usuarioAtual.id = 0;

        //Não é permitido executar ações no banco de dados na Thread principal do Android sendo assim,
        //precio criar uma nova Thread para que a atividade seja executada em background 
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                //chama o método para inserir um novo contato
                db.usuarioDAO().insertUsuario(usuarioAtual);

                atualizaAgenda();
            }
        }).start();
    }

    private void atualizaAgenda() {

        //chama o método para buscar todos os contatos salvos na tabela
        List<Usuario> listaUsuarios = db.usuarioDAO().selectAll();

        //db.usuarioDAO().deleteAll(listaUsuarios);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                ArrayAdapter<Usuario> adaptador = new ArrayAdapter<>(MainActivity.this,
                        com.google.android.material.R.layout.support_simple_spinner_dropdown_item, listaUsuarios);

                agendaUsuarios.setAdapter(adaptador);
            }
        });
    }
}