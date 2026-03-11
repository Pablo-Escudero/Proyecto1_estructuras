package eventos;

import gestion.Lugar;

public class EventoPrivado extends Evento {

    private static final long serialVersionUID = 1L;

    private String cliente;
    private String nivelConfidencialidad;

    public EventoPrivado(String nombreEvento, String fecha,
                         Lugar lugar, String cliente,
                         String nivelConfidencialidad) {

        super(nombreEvento, fecha, lugar);
        this.cliente = cliente;
        this.nivelConfidencialidad = nivelConfidencialidad;
    }

    public String getCliente() {
        return cliente;
    }

    public String getNivelConfidencialidad() {
        return nivelConfidencialidad;
    }

    @Override
    public String mostrarDetalles() {

        return "Evento Privado: " + nombreEvento +
                " | Fecha: " + fecha +
                " | Lugar: " + lugar.getNombre() +
                " | Cliente: " + cliente +
                " | Nivel: " + nivelConfidencialidad;

    }

    @Override
    public String tipoEvento() {
        return "Privado";
    }
}