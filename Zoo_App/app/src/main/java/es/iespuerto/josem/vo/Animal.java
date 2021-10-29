package es.iespuerto.josem.vo;

import android.content.ContentValues;

import java.util.Date;

import es.iespuerto.josem.model.contract.AnimalContract;

public class Animal {

    int numeroIdentificacion;
    String especie, sexo, paisOrigen, continente;
    Date anoNacimiento;

    public Animal() {
    }

    public Animal(int númeroIdentificación, String especie, String sexo, String paisOrigen, String continente, Date anoNacimiento) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.especie = especie;
        this.sexo = sexo;
        this.paisOrigen = paisOrigen;
        this.continente = continente;
        this.anoNacimiento = anoNacimiento;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AnimalContract.AnimalEntry.N_IDENTIFICACION, numeroIdentificacion);
        values.put(AnimalContract.AnimalEntry.ESPECIE, especie);
        values.put(AnimalContract.AnimalEntry.SEXO, sexo);
        values.put(AnimalContract.AnimalEntry.PAIS_ORIGEN, paisOrigen);
        values.put(AnimalContract.AnimalEntry.CONTINENTE, continente);
        values.put(AnimalContract.AnimalEntry.ANO_NACIMIENTO, anoNacimiento.toString());
        return values;
    }
}
