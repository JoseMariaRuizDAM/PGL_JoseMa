package es.iespuerto.josem.model.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import es.iespuerto.josem.model.contract.AnimalContract;
import es.iespuerto.josem.model.contract.EspecieContract;

public class EspecieHelper extends ComunDBHelper {

    public EspecieHelper(Context context){
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + EspecieContract.EspecieEntry.TABLE_NAME + " ("
                + AnimalContract.AnimalEntry.N_IDENTIFICACION + " INTEGER PRIMARY KEY,"
                + AnimalContract.AnimalEntry.ESPECIE + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.SEXO + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.PAIS_ORIGEN + "TEXT ,"
                + AnimalContract.AnimalEntry.CONTINENTE + "TEXT ,"
                + AnimalContract.AnimalEntry.ANO_NACIMIENTO + "DATE NOT NULL)");
    }
}
