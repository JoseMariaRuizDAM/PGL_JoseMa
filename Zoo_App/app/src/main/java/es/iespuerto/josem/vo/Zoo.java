package es.iespuerto.josem.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.iespuerto.josem.model.contract.AnimalContract;
import es.iespuerto.josem.model.contract.ZooContract;

public class Zoo {

    int numeroIdentificacion;
    String nombre, ciudad, pais;
    double tamano;
    double presupuesto;

    public Zoo(){

    }

    public Zoo(String nombre, String ciudad, String pais, double tamano, double presupuesto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tamano = tamano;
        this.presupuesto = presupuesto;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ZooContract.ZooEntry._ID, numeroIdentificacion);
        values.put(ZooContract.ZooEntry.NOMBRE, nombre);
        values.put(ZooContract.ZooEntry.CIUDAD, ciudad);
        values.put(ZooContract.ZooEntry.PAIS, pais);
        values.put(ZooContract.ZooEntry.TAMANO, tamano);
        values.put(ZooContract.ZooEntry.PRESUPUESTO, presupuesto);
        return values;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Funcion que determina si dos objetos de la clase user, son iguales
     * @param o objeto a evuluar
     * @return true/false con la evaluacion
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(numeroIdentificacion, zoo.numeroIdentificacion)
                && Objects.equals(nombre, zoo.nombre)
                && Objects.equals(ciudad, zoo.ciudad)
                && Objects.equals(pais, zoo.pais)
                && Objects.equals(tamano, zoo.tamano);
    }
}
