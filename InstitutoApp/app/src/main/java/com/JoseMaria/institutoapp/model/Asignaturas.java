package com.JoseMaria.institutoapp.model;

import android.content.ContentValues;

import com.JoseMaria.institutoapp.database.contract.AsignaturaMatriculaContract;
import com.JoseMaria.institutoapp.database.contract.AsignaturasContract;

public class Asignaturas {

    int idAsignatura;
    String nombre;
    String curso;

    //Constructor vacio por defecto
    public Asignaturas(){

    }

    //Constructor con todos los atributos de la clase
    public Asignaturas(int idAsignatura, String nombre, String curso) {
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
        this.curso = curso;
    }

    //Comienzo de getters y setters
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Funcion encargada de transformar un objeto del modelo a un elemeno
     * que interactua con la BBDD
     * @return Asignaturas con formato ContentValues
     */
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(AsignaturasContract.AsignaturasEntry.ID_ASIGNATURA, this.idAsignatura);
        values.put(AsignaturasContract.AsignaturasEntry.NOMBRE, this.nombre);
        values.put(AsignaturasContract.AsignaturasEntry.CURSO, this.curso);
        return values;
    }
}
