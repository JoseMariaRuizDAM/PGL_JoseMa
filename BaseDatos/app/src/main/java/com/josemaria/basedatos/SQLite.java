package com.josemaria.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    public SQLite(@Nullable Context context, @Nullable String name,
                  @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //unique para que solo pueda ser una descripcion unica en toda la base de datos

        db.execSQL("create table productos (codigo int primary key, descripcion text unique, precio real, stock int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    }

    public void eliminarTabla(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS productos");
    }
}
