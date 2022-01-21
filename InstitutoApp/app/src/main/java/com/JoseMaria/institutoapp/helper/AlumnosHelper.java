package com.JoseMaria.institutoapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.JoseMaria.institutoapp.database.contract.AlumnosContract;
import com.JoseMaria.institutoapp.model.Alumnos;

public class AlumnosHelper extends ComunHelper {

    public AlumnosHelper(Context context){
        super(context);
    }

    /**
     * Medodo encargado de realizar la insercion
     * @param alumnos que se utiliza en la operacion
     */
    public boolean add(Alumnos alumnos) {
        return super.add(AlumnosContract.AlumnosEntry.TABLE_NAME,
                alumnos.toContentValues());
    }
}
