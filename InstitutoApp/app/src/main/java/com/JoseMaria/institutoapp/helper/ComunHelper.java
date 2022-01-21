package com.JoseMaria.institutoapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.JoseMaria.institutoapp.database.contract.AlumnosContract;
import com.JoseMaria.institutoapp.database.contract.AsignaturaMatriculaContract;
import com.JoseMaria.institutoapp.database.contract.AsignaturasContract;
import com.JoseMaria.institutoapp.database.contract.MatriculasContract;

public class ComunHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "instituto.db";

    public ComunHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /**
     * Metodo encargado de realizar creacion de todas las tablas de la BBDD
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Se crean las tablas de la BBDD de instituto
        sqLiteDatabase.execSQL(AlumnosContract.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(AsignaturasContract.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(MatriculasContract.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(AsignaturaMatriculaContract.SQL_CREATE_ENTRIES);
    }

    /**
     * Metodo encargado de realizar la actualizacion de la bbdd
     * @param sqLiteDatabase
     * @param oldVersion version anterior
     * @param newVersion version a actualizar
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(AsignaturaMatriculaContract.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(AsignaturasContract.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(MatriculasContract.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(AlumnosContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
