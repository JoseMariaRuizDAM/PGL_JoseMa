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
import es.iespuerto.josem.model.contract.ZooContract;
import es.iespuerto.josem.vo.Animal;
import es.iespuerto.josem.vo.Zoo;

public class ZooHelper extends ComunDBHelper{

    public ZooHelper(Context context){
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ZooContract.ZooEntry.TABLE_NAME + " ("
                + ZooContract.ZooEntry._ID + " INT PRIMARY KEY NOT NULL,"
                + ZooContract.ZooEntry.NOMBRE + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.CIUDAD + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.PAIS + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.PRESUPUESTO + " DOUBLE NOT NULL,"
                + ZooContract.ZooEntry.TAMANO + "DOUBLE NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }

    /**
     * Funcion encargada en realizar el almacenamiento de un usuario
     *
     * @param zoo Animal de la BBDD
     * @return identificador con el resultado en el proceso de almacenar
     * en la BBDD
     */
    public long save(Zoo zoo) {
        return super.save(ZooContract.ZooEntry.TABLE_NAME,
                zoo.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Zoo> getAll() {

        List<Zoo> zooList = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                zooList = new ArrayList<>();
                do {
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE);
                    @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                    @SuppressLint("Range") double tamano = cursor.getDouble(cursor.getColumnIndex(ZooContract.ZooEntry.TAMANO));
                    @SuppressLint("Range") double presupuesto = cursor.getDouble(cursor.getColumnIndex(ZooContract.ZooEntry.PRESUPUESTO));

                    Zoo zoo = new Zoo(nombre, ciudad, pais, tamano, presupuesto);
                    zooList.add(zoo);
                } while (cursor.moveToNext());
                return zooList;
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
    public List<Zoo> getById(String id) {
        List<Zoo> zooList = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null,
                    ZooContract.ZooEntry._ID + " = ?",
                    new String[]{id},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                zooList = new ArrayList<>();
                do {
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE);
                    @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                    @SuppressLint("Range") double tamano = cursor.getDouble(cursor.getColumnIndex(ZooContract.ZooEntry.TAMANO));
                    @SuppressLint("Range") double presupuesto = cursor.getDouble(cursor.getColumnIndex(ZooContract.ZooEntry.PRESUPUESTO));

                    Zoo zoo = new Zoo(nombre, ciudad, pais, tamano, presupuesto);
                    zooList.add(zoo);
                } while (cursor.moveToNext());
                return zooList;
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
        return super.delete(ZooContract.ZooEntry.TABLE_NAME,
                ZooContract.ZooEntry._ID + " = ?",
                new String[]{id});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param zoo idea a actualizar en la app
     * @param id idea relacionado
     * @return intero con el valor de la operacion
     */
    public int update(Zoo zoo, String id) {
        return super.update(ZooContract.ZooEntry.TABLE_NAME,
                zoo.toContentValues(),
                ZooContract.ZooEntry._ID + " = ?",
                new String[]{id});
    }
}
