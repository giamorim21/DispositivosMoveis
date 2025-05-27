package com.example.revisaoprova2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface GastoDAO {
    @Insert
    void insert(Gasto gasto);

    @Query("SELECT * FROM gastos")
    List<Gasto> buscaTodosGastos();

    @Query("SELECT * FROM gastos ORDER BY valor DESC LIMIT 1")
    Gasto buscaMaiorGasto();
}
