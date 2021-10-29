package es.iespuerto.josem.vo;

public class Zoo {

    String nombre, ciudad, país;
    double tamaño;
    double presupuesto;

    public Zoo(){

    }
    public Zoo(String nombre, String ciudad, String país, double tamaño, double presupuesto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.país = país;
        this.tamaño = tamaño;
        this.presupuesto = presupuesto;
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

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
