package com.JoseMaria.institutoapp.database.contract;

import android.provider.BaseColumns;

public class AsignaturaMatriculaContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AsignaturaMatriculaContract.AsignaturaMatriculaEntry.TABLE_NAME + " (" +
                    AsignaturaMatriculaContract.AsignaturaMatriculaEntry._ID + " INTEGER PRIMARY KEY," +
                    AsignaturaMatriculaContract.AsignaturaMatriculaEntry.ID_MATRICULA + " INTEGER, " +
                    AsignaturaMatriculaContract.AsignaturaMatriculaEntry.ID_ASIGNATURA + " INTEGER);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AsignaturaMatriculaContract.AsignaturaMatriculaEntry.TABLE_NAME;

    private AsignaturaMatriculaContract(){

    }

    public static class AsignaturaMatriculaEntry implements BaseColumns {
        public static final String TABLE_NAME = "asignatura_matricula";
        public static final String ID_MATRICULA = "idmatricula";
        public static final String ID_ASIGNATURA = "idasignatura";
    }
}
