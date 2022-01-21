package com.JoseMaria.institutoapp.database.contract;

import android.provider.BaseColumns;

public class MatriculasContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MatriculasContract.MatriculasEntry.TABLE_NAME + " (" +
                    MatriculasContract.MatriculasEntry._ID + " INTEGER PRIMARY KEY," +
                    MatriculasContract.MatriculasEntry.ID_MATRICULA + " INTEGER, " +
                    MatriculasContract.MatriculasEntry.DNI + " TEXT, " +
                    MatriculasContract.MatriculasEntry.YEAR + " LONG);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MatriculasContract.MatriculasEntry.TABLE_NAME;

    private MatriculasContract(){

    }

    public static class MatriculasEntry implements BaseColumns {
        public static final String TABLE_NAME = "matriculas";
        public static final String ID_MATRICULA = "idmatricula";
        public static final String DNI = "dni";
        public static final String YEAR = "year";
    }
}
