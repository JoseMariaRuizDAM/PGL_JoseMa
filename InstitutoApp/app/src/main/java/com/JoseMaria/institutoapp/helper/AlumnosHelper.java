package com.JoseMaria.institutoapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.JoseMaria.institutoapp.database.contract.AlumnosContract;
import com.JoseMaria.institutoapp.model.Alumnos;

import java.util.ArrayList;
import java.util.List;

public class AlumnosHelper extends ComunHelper {

    public AlumnosHelper(Context context){
        super(context);
    }

    /**
     * Medodo encargado de realizar la insercion
     * @param alumnos que se utiliza en la operacion
     */
    public void add(Alumnos alumnos) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AlumnosContract.AlumnosEntry.DNI, alumnos.getDni());

        db.insert(AlumnosContract.AlumnosEntry.TABLE_NAME, null,contentValues);
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * @param alumnos con los datos a actualizar
     * @return True en caso de que la actualizacion haya sido correcta.
     * False en caso contrario
     */
    public boolean update(Alumnos alumnos) {
        boolean resultado = false;
        String selection = AlumnosContract.AlumnosEntry._ID + " = ?";
        String[] selectionArgs = { alumnos.getNombre() };

        int filasAfectadas = getWritableDatabase().update(
                AlumnosContract.AlumnosEntry.TABLE_NAME,
                alumnos.toContentValues(),
                selection,
                selectionArgs);

        if (filasAfectadas > 0) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Funcion que realiza la eliminacion de un elemento sobre la table
     * @param alumnos que se va a eliminar
     * @return True en caso de que la eliminación haya sido correcta. False
     * en caso contrario
     */
    public boolean delete(Alumnos alumnos) {

        boolean resultado = false;
        String selection = AlumnosContract.AlumnosEntry._ID + " = ?";
        String[] selectionArgs = { alumnos.getDni() };

        int filasAfectadas = getWritableDatabase().delete(
                AlumnosContract.AlumnosEntry.TABLE_NAME,
                selection,
                selectionArgs);

        if (filasAfectadas > 0) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Funcion que realiza la busqueda de un elemento a traves de su id
     * @param dni del usuario
     * @return con los tados del usuario
     */
    public Alumnos searchOne(String dni) {

        SQLiteDatabase db = getReadableDatabase();
        Alumnos alumno = null;
        String selection = AlumnosContract.AlumnosEntry.DNI + " = ?";
        String[] selectionArgs = {dni};
        Cursor cursor = db.query(AlumnosContract.AlumnosEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                alumno = new Alumnos(cursor.getString(cursor.getColumnIndexOrThrow(
                        AlumnosContract.AlumnosEntry.DNI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnosContract.AlumnosEntry.NOMBRE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnosContract.AlumnosEntry.APELLIDOS)),
                        cursor.getLong(cursor.getColumnIndexOrThrow(
                                AlumnosContract.AlumnosEntry.FECHA_NAC)));
            }
            cursor.close();
        }
        return alumno;
    }

    /**
     * Funcion que realiza la busqueda de todos los usuarios
     * @return lista de alumnos
     */
    public List<Alumnos> searchAll() {
        SQLiteDatabase db = getReadableDatabase();
        List<Alumnos> alumnos = new ArrayList<>();
        Cursor cursor = db.query(AlumnosContract.AlumnosEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor != null) {
            while(cursor.moveToNext()) {
                alumnos.add(new Alumnos(cursor.getString(cursor.getColumnIndexOrThrow(
                        AlumnosContract.AlumnosEntry.DNI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnosContract.AlumnosEntry.NOMBRE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnosContract.AlumnosEntry.APELLIDOS)),
                        cursor.getLong(cursor.getColumnIndexOrThrow(
                                AlumnosContract.AlumnosEntry.FECHA_NAC))));
            }
            cursor.close();
        }
        return alumnos;
    }

}
