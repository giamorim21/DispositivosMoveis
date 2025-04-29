package com.example.agendacomsql;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nome;
    private TextInputEditText telefone;
    private Button salvar;
    private ListView contatos;
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

    private void inicializaTela() {
        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        salvar = findViewById(R.id.botao);
        contatos = findViewById(R.id.lista);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaContato();

            }
        });
    }

    @SuppressLint("Range")
    private void salvaContato() {
        String nomeInformado = nome.getText().toString();
        String telefoneInformado = telefone.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase("agenda.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tab_contatos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT)");

        db.execSQL("INSERT INTO tab_contatos(nome, telefone) VALUES ('"+nomeInformado+"', '"+telefoneInformado+"') ");

        Cursor cursor = db.rawQuery("SELECT * FROM tab_contatos", null);

        ArrayList<String> usuarios = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                Log.d("SQL", "NOME CADASTRADO: " + nome);
                usuarios.add("Nome: " + nome + " Telefone: " + telefone);
            } while (cursor.moveToNext());
        }

        Toast.makeText(MainActivity.this, R.string.toast_salvar , Toast.LENGTH_LONG).show();


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, usuarios);

        contatos.setAdapter(adapter);
    }
}