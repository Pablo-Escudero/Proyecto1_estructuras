public abstract class Evento {

    protected String nombreEvento;
    protected String fecha;
    protected Lugar lugar;

    protected Modelo[] modelos;
    protected Fotografo[] fotografos;

    protected int numModelos;
    protected int numFotografos;

    public Evento(String nombreEvento, String fecha, Lugar lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;

        modelos = new Modelo[50];
        fotografos = new Fotografo[20];

        numModelos = 0;
        numFotografos = 0;
    }

    public abstract String mostrarDetalles();
    public abstract String tipoEvento();
}