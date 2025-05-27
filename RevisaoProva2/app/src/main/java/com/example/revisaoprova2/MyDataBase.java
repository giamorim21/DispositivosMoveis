package com.example.revisaoprova2;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Gasto.class}, version = 1)
public abstract class MyDataBase extends RoomDatabase {

    public abstract GastoDAO gastoDAO();

}
