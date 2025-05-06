package com.example.persistenciacomroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Insert
    void  insertUsuario (Usuario usuario);
    @Query("SELECT * FROM tab_usuario")
    List<Usuario> selectAll();
}
