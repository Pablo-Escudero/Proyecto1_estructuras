public class EventoPublico extends Evento {

    private int capacidadAsistentes;
    private String patrocinador;

    public EventoPublico(String nombre, String fecha, Lugar lugar,
                         int capacidadAsistentes, String patrocinador) {

        super(nombre, fecha, lugar);

        this.capacidadAsistentes = capacidadAsistentes;
        this.patrocinador = patrocinador;
    }

    @Override
    public String mostrarDetalles() {
        return "Evento Público: " + nombreEvento +
                " | Fecha: " + fecha +
                " | Lugar: " + lugar.getNombreLugar() +
                " | Patrocinador: " + patrocinador;
    }

    @Override
    public String tipoEvento() {
        return "Publico";
    }
}