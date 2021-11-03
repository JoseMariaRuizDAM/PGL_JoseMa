package es.iespuerto.josem.vo;

import android.content.ContentValues;

import es.iespuerto.josem.model.contract.EspecieContract;

public class Especie {

    String nombreVulgar, nombreCientífico, familia;
    boolean peligroExtinción;

    public Especie() {
    }

    public Especie(String nombreVulgar, String nombreCientífico, String familia, boolean peligroExtinción) {
        this.nombreVulgar = nombreVulgar;
        this.nombreCientífico = nombreCientífico;
        this.familia = familia;
        this.peligroExtinción = peligroExtinción;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(EspecieContract.EspecieEntry.NOMBRE_VULGAR, nombreVulgar);
        values.put(EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO, nombreCientífico);
        values.put(EspecieContract.EspecieEntry.FAMILIA, familia);
        values.put(EspecieContract.EspecieEntry.PELIGRO_EXTINCION, peligroExtinción);

        return values;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientífico() {
        return nombreCientífico;
    }

    public void setNombreCientífico(String nombreCientífico) {
        this.nombreCientífico = nombreCientífico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public boolean isPeligroExtinción() {
        return peligroExtinción;
    }

    public void setPeligroExtinción(boolean peligroExtinción) {
        this.peligroExtinción = peligroExtinción;
    }
}
