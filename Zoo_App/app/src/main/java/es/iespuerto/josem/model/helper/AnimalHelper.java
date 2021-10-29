package es.iespuerto.josem.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
        List<Animal> ideas = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                ideas = new ArrayList<>();
                do {
                    @SuppressLint("Range") int numeroIdentificacion = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.N_IDENTIFICACION));
                    @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                    @SuppressLint("Range") String especie = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.ESPECIE));
                    @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                    @SuppressLint("Range") int nacimiento = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.ANO_NACIMIENTO));
                    Idea idea = new Idea(user, descripcion);
                    ideas.add(idea);
                } while (cursor.moveToNext());
                return ideas;
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
    public List<Idea> getAll(String idUser) {
        List<Idea> ideas = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(IdeaContract.IdeaEntry.TABLE_NAME,
                    null,
                    IdeaContract.IdeaEntry.IDUSER + " = ?",
                    new String[]{idUser},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                ideas = new ArrayList<>();
                do {
                    @SuppressLint("Range") String descripcion = cursor.getString(cursor.getColumnIndex(IdeaContract.IdeaEntry.DESCRIPCION));
                    Idea idea = new Idea(idUser, descripcion);
                    ideas.add(idea);
                } while (cursor.moveToNext());
                return ideas;
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
        return super.delete(UserContract.UserEntry.TABLE_NAME,
                IdeaContract.IdeaEntry._ID + " = ?",
                new String[]{id});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param idea idea a actualizar en la app
     * @param id idea relacionado
     * @return intero con el valor de la operacion
     */
    public int update(Idea idea, String id) {
        return super.update(IdeaContract.IdeaEntry.TABLE_NAME,
                idea.toContentValues(),
                IdeaContract.IdeaEntry._ID + " = ?",
                new String[]{id});
    }
}
