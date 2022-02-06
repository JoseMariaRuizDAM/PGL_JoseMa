package com.JoseMaria.institutoapp.model;

import android.content.ContentValues;

import com.JoseMaria.institutoapp.database.contract.AlumnosContract;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Alumnos {

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("apellidos")
    @Expose
    private String apellidos;

    @SerializedName("fechaNacimiento")
    @Expose
    private long fechaNacimiento;

    //Constructor vacio por defecto
    public Alumnos(){

    }

    //Constructor con todos los atributos de la clase
    public Alumnos(String dni, String nombre, String apellidos, long fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Getters y setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Funcion encargada de transformar un objeto del modelo a un elemeno
     * que interactua con la BBDD
     * @return Alumnos con formato ContentValues
     */
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(AlumnosContract.AlumnosEntry.DNI, this.dni);
        values.put(AlumnosContract.AlumnosEntry.NOMBRE, this.nombre);
        values.put(AlumnosContract.AlumnosEntry.APELLIDOS, this.apellidos);
        values.put(AlumnosContract.AlumnosEntry.FECHA_NAC, this.fechaNacimiento);
        return values;
    }

}
