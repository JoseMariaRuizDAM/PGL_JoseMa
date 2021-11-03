package es.iespuerto.josem.vo;

import android.content.ContentValues;

import java.util.Date;

import es.iespuerto.josem.model.contract.AnimalContract;

public class Animal {

    int numeroIdentificacion, anoNacimiento;
    String especie, sexo, paisOrigen, continente;

    public Animal() {
    }

    public Animal(int númeroIdentificación, String especie, String sexo, String paisOrigen, String continente, int anoNacimiento) {
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
        values.put(AnimalContract.AnimalEntry.ANO_NACIMIENTO, anoNacimiento);
        return values;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
