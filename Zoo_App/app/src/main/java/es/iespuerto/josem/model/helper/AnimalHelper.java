package es.iespuerto.josem.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import es.iespuerto.josem.model.contract.AnimalContract;
import es.iespuerto.josem.vo.Animal;

public class AnimalHelper extends ComunDBHelper {


    public AnimalHelper(Context context) {
        super(context);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NAME + " ("
                + AnimalContract.AnimalEntry.N_IDENTIFICACION + " INTEGER PRIMARY KEY,"
                + AnimalContract.AnimalEntry.ESPECIE + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.SEXO + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.PAIS_ORIGEN + "TEXT ,"
                + AnimalContract.AnimalEntry.CONTINENTE + "TEXT ,"
                + AnimalContract.AnimalEntry.ANO_NACIMIENTO + "DATE NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }

    /**
     * Funcion encargada en realizar el almacenamiento de un usuario
     *
     * @param animal Animal de la BBDD
     * @return identificador con el resultado en el proceso de almacenar
     * en la BBDD
     */
    public long save(Animal animal) {
        return super.save(AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Animal> getAll() {
        List<Animal> animales = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                animales = new ArrayList<>();
                do {
                    @SuppressLint("Range") int numeroIdentificacion = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.N_IDENTIFICACION));
                    @SuppressLint("Range") String paisOrigen = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.PAIS_ORIGEN));
                    @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                    @SuppressLint("Range") String especie = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.ESPECIE));
                    @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                    @SuppressLint("Range") int anoNacimiento = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.ANO_NACIMIENTO));
                    Animal animal = new Animal(numeroIdentificacion, continente,paisOrigen, especie, sexo, anoNacimiento);
                    animales.add(animal);
                } while (cursor.moveToNext());
                return animales;
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
     * @param idUser identificador del usuario
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Animal> getAll(String idAnimal) {
        List<Animal> animales = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null,
                    AnimalContract.AnimalEntry.N_IDENTIFICACION + " = ?",
                    new String[]{idAnimal},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                animales = new ArrayList<>();
                do {
                    @SuppressLint("Range") int numeroIdentificacion = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.N_IDENTIFICACION));
                    @SuppressLint("Range") String paisOrigen = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.PAIS_ORIGEN));
                    @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                    @SuppressLint("Range") String especie = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.ESPECIE));
                    @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                    @SuppressLint("Range") int anoNacimiento = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.ANO_NACIMIENTO));
                    Animal animal = new Animal(numeroIdentificacion, continente,paisOrigen, especie, sexo, anoNacimiento);
                    animales.add(animal);
                } while (cursor.moveToNext());
                return animales;
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
        return super.delete(AnimalContract.AnimalEntry.TABLE_NAME,
                AnimalContract.AnimalEntry.N_IDENTIFICACION + " = ?",
                new String[]{id});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param animal idea a actualizar en la app
     * @param id idea relacionado
     * @return intero con el valor de la operacion
     */
    public int update(Animal animal, String id) {
        return super.update(AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues(),
                AnimalContract.AnimalEntry.N_IDENTIFICACION + " = ?",
                new String[]{id});
    }
}
