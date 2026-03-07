public class EventoPrivado extends Evento {

    private String cliente;
    private String nivelConfidencialidad;

    public EventoPrivado(String nombre, String fecha, Lugar lugar,
                         String cliente, String nivelConfidencialidad) {

        super(nombre, fecha, lugar);

        this.cliente = cliente;
        this.nivelConfidencialidad = nivelConfidencialidad;
    }

    @Override
    public String mostrarDetalles() {
        return "Evento Privado: " + nombreEvento +
                " | Cliente: " + cliente +
                " | Confidencialidad: " + nivelConfidencialidad;
    }

    @Override
    public String tipoEvento() {
        return "Privado";
    }
}