package modelos;

public class Modelo extends Persona {

    private static final long serialVersionUID = 1L;

    private String codigoModelo;
    private double estatura;
    private String categoria;
    private boolean disponible;

    public Modelo(String nombre, String identificacion, String contacto,
                  String codigoModelo, double estatura,
                  String categoria, boolean disponible) {

        super(nombre, identificacion, contacto);
        this.codigoModelo = codigoModelo;
        this.estatura = estatura;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public String getCodigoModelo() {
        return codigoModelo;
    }

    public double getEstatura() {
        return estatura;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String mostrarInformacion() {
        return nombre + " | Código: " + codigoModelo +
                " | Estatura: " + estatura +
                " | Categoría: " + categoria +
                " | Disponible: " + (disponible ? "Sí" : "No");
    }

}