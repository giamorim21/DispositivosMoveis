package com.example.persistenciacomroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tab_usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "login")
    String login;
    @ColumnInfo(name = "senha")
    String senha;
}
