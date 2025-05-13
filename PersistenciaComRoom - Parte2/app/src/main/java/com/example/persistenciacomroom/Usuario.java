package com.example.persistenciacomroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tab_usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "login")
    private String login;
    @ColumnInfo(name = "senha")
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login = " + login + ", Senha = " + senha;
    }
}
