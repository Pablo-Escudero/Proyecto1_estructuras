package gestion;

public class Lugar {

    private String nombreLugar;
    private String direccion;
    private String ciudad;
    private int capacidad;
    private String tipoLugar;

    public Lugar(String nombreLugar, String direccion,
                 String ciudad, int capacidad, String tipoLugar) {

        this.nombreLugar = nombreLugar;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.tipoLugar = tipoLugar;
    }

    public String getNombre() {
        return nombreLugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTipoLugar() {
        return tipoLugar;
    }

    public String mostrarLugar() {
        return nombreLugar + " - " + ciudad + " (" + tipoLugar + ")";
    }

    public String toArchivo() {
        return nombreLugar + "," + direccion + "," +
                ciudad + "," + capacidad + "," + tipoLugar;
    }

    @Override
    public String toString() {
        return nombreLugar + " - " + ciudad;
    }
}