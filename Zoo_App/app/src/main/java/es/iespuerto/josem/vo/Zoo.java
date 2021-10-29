package es.iespuerto.josem.vo;

import android.content.ContentValues;

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
}
