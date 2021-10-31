package es.iespuerto.josem.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.iespuerto.josem.model.contract.AnimalContract;
import es.iespuerto.josem.model.contract.EspecieContract;
import es.iespuerto.josem.vo.Animal;
import es.iespuerto.josem.vo.Especie;

public class EspecieHelper extends ComunDBHelper {

    public EspecieHelper(Context context){
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + EspecieContract.EspecieEntry.TABLE_NAME + " ("
                + EspecieContract.EspecieEntry._ID + " INT PRIMARY KEY NOT NULL,"
                + EspecieContract.EspecieEntry.NOMBRE_VULGAR + " TEXT NOT NULL,"
                + EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO + " TEXT NOT NULL,"
                + EspecieContract.EspecieEntry.FAMILIA + " TEXT NOT NULL,"
                + EspecieContract.EspecieEntry.PELIGRO_EXTINCION + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }

    /**
     * Funcion encargada en realizar el almacenamiento de un usuario
     *
     * @param especie Animal de la BBDD
     * @return identificador con el resultado en el proceso de almacenar
     * en la BBDD
     */
    public long save(Especie especie) {
        return super.save(AnimalContract.AnimalEntry.TABLE_NAME,
                especie.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Especie> getAll() {
        List<Especie> especies = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(EspecieContract.EspecieEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                especies = new ArrayList<>();
                do {
                    @SuppressLint("Range") String _id = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry._ID));
                    @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_VULGAR));
                    @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO));
                    @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.FAMILIA));
                    @SuppressLint("Range") boolean peligroExtincion = cursor.equals(cursor.getColumnIndex(EspecieContract.EspecieEntry.PELIGRO_EXTINCION));
                    Especie especie = new Especie(nombreVulgar, nombreCientifico, familia, peligroExtincion);
                    especies.add(especie);
                } while (cursor.moveToNext());
                return especies;
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar las excepciones
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList(); //Retornamos una lista vacia
    }


    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @param id identificador del usuario
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Especie> getAll(String id) {
        List<Especie> especies = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(EspecieContract.EspecieEntry.TABLE_NAME,
                    null,
                    EspecieContract.EspecieEntry._ID + " = ?",
                    new String[]{id},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                especies = new ArrayList<>();
                do {
                    @SuppressLint("Range") String _id = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry._ID));
                    @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_VULGAR));
                    @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO));
                    @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.FAMILIA));
                    @SuppressLint("Range") boolean peligroExtincion = cursor.equals(cursor.getColumnIndex(EspecieContract.EspecieEntry.PELIGRO_EXTINCION));
                    Especie especie = new Especie(nombreVulgar, nombreCientifico, familia, peligroExtincion);
                    especies.add(especie);
                } while (cursor.moveToNext());
                return especies;
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar las excepciones
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList(); //Retornamos una lista vacia
    }



    /**
     * Funcion encargada en eliminar un elemento de la BBBDD
     * @param id identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String id) {
        return super.delete(EspecieContract.EspecieEntry.TABLE_NAME,
                EspecieContract.EspecieEntry._ID + " = ?",
                new String[]{id});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param especie idea a actualizar en la app
     * @param id idea relacionado
     * @return intero con el valor de la operacion
     */
    public int update(Especie especie, String id) {
        return super.update(EspecieContract.EspecieEntry.TABLE_NAME,
                especie.toContentValues(),
                EspecieContract.EspecieEntry._ID + " = ?",
                new String[]{id});
    }
}
