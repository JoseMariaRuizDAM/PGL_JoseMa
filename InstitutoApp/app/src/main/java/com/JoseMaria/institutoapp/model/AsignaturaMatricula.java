package com.JoseMaria.institutoapp.model;

import android.content.ContentValues;

import com.JoseMaria.institutoapp.database.contract.AlumnosContract;
import com.JoseMaria.institutoapp.database.contract.AsignaturaMatriculaContract;
import com.JoseMaria.institutoapp.database.contract.AsignaturasContract;

public class AsignaturaMatricula {

    int id;
    int idMatricula;
    int idAsignatura;

    //Constructor vacio por defecto
    public AsignaturaMatricula(){

    }

    //Constructor con todos los atributos de la clase
    public AsignaturaMatricula(int id, int idMatricula, int idAsignatura) {
        this.id = id;
        this.idMatricula = idMatricula;
        this.idAsignatura = idAsignatura;
    }

    //Comienzo de getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    /**
     * Funcion encargada de transformar un objeto del modelo a un elemeno
     * que interactua con la BBDD
     * @return AsignaturaMatricula con formato ContentValues
     */
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(AsignaturaMatriculaContract.AsignaturaMatriculaEntry._ID, this.id);
        values.put(AsignaturaMatriculaContract.AsignaturaMatriculaEntry.ID_MATRICULA, this.idMatricula);
        values.put(AsignaturaMatriculaContract.AsignaturaMatriculaEntry.ID_ASIGNATURA, this.idAsignatura);
        return values;
    }
}
