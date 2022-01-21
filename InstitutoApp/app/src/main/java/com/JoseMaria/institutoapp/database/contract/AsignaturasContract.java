package com.JoseMaria.institutoapp.database.contract;

import android.provider.BaseColumns;

public class AsignaturasContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AsignaturasContract.AsignaturasEntry.TABLE_NAME + " (" +
                    AsignaturasContract.AsignaturasEntry._ID + " INTEGER PRIMARY KEY," +
                    AsignaturasContract.AsignaturasEntry.ID_ASIGNATURA + " INTEGER, " +
                    AsignaturasContract.AsignaturasEntry.NOMBRE + " TEXT, " +
                    AsignaturasContract.AsignaturasEntry.CURSO+ " TEXT);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AsignaturasContract.AsignaturasEntry.TABLE_NAME;

    private AsignaturasContract(){

    }

    public static class AsignaturasEntry implements BaseColumns {
        public static final String TABLE_NAME = "asignaturas";
        public static final String ID_ASIGNATURA= "idasignatura";
        public static final String NOMBRE= "nombre";
        public static final String CURSO = "curso";
    }
}
