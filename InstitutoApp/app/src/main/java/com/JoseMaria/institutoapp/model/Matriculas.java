package com.JoseMaria.institutoapp.model;

import android.content.ContentValues;

import com.JoseMaria.institutoapp.database.contract.AsignaturasContract;
import com.JoseMaria.institutoapp.database.contract.MatriculasContract;

public class Matriculas {

    int idMatricula;
    String dni;
    long year;

    //Constructor vacio por defecto
    public Matriculas(){

    }

    //Constructor con todos los atributos de la clase
    public Matriculas(int idMatricula, String dni, long year) {
        this.idMatricula = idMatricula;
        this.dni = dni;
        this.year = year;
    }

    //Comienzo de getters y setters
    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    /**
     * Funcion encargada de transformar un objeto del modelo a un elemeno
     * que interactua con la BBDD
     * @return Matriculas con formato ContentValues
     */
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(MatriculasContract.MatriculasEntry.ID_MATRICULA, this.idMatricula);
        values.put(MatriculasContract.MatriculasEntry.DNI, this.dni);
        values.put(MatriculasContract.MatriculasEntry.YEAR, this.year);
        return values;
    }
}
