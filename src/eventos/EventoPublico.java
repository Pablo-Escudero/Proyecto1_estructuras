package eventos;

import gestion.Lugar;

public class EventoPublico extends Evento {

    private int capacidadAsistentes;
    private String patrocinador;

    public EventoPublico(String nombreEvento, String fecha,
                         Lugar lugar, int capacidadAsistentes,
                         String patrocinador) {

        super(nombreEvento, fecha, lugar);
        this.capacidadAsistentes = capacidadAsistentes;
        this.patrocinador = patrocinador;
    }

    public int getCapacidadAsistentes() {
        return capacidadAsistentes;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    @Override
    public String mostrarDetalles() {

        return "Evento Público: " + nombreEvento +
                " | Fecha: " + fecha +
                " | Lugar: " + lugar.getNombre() +
                " | Patrocinador: " + patrocinador +
                " | Capacidad: " + capacidadAsistentes;

    }

    @Override
    public String tipoEvento() {
        return "Publico";
    }
}