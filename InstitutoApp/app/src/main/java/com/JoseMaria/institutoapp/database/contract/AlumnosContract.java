package com.JoseMaria.institutoapp.database.contract;

import android.provider.BaseColumns;

public class AlumnosContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AlumnosEntry.TABLE_NAME + " (" +
                    AlumnosEntry._ID + " INTEGER PRIMARY KEY," +
                    AlumnosEntry.DNI + " TEXT, " +
                    AlumnosEntry.NOMBRE + " TEXT, " +
                    AlumnosEntry.APELLIDOS + " TEXT, " +
                    AlumnosEntry.FECHA_NAC + " LONG);";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AlumnosEntry.TABLE_NAME;

    private AlumnosContract(){

    }

    public static class AlumnosEntry implements BaseColumns{
        private  String name;
        public static final String TABLE_NAME = "alumnos";
        public static final String DNI = "dni";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDOS = "apellidos";
        public static final String FECHA_NAC = "fechanacimiento";
    }
}
