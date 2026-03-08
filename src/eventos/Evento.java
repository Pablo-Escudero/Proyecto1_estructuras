package eventos;

import gestion.Lugar;
import modelos.Modelo;
import modelos.Fotografo;

public abstract class Evento {

    protected String nombreEvento;
    protected String fecha;
    protected Lugar lugar;

    protected Modelo[] modelos = new Modelo[20];
    protected Fotografo[] fotografos = new Fotografo[10];

    protected int numModelos = 0;
    protected int numFotografos = 0;

    public Evento(String nombreEvento, String fecha, Lugar lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Modelo[] getModelos() {
        return modelos;
    }

    public int getNumModelos() {
        return numModelos;
    }

    public Fotografo[] getFotografos() {
        return fotografos;
    }

    public int getNumFotografos() {
        return numFotografos;
    }

    public void agregarModelo(Modelo m) {

        if (numModelos < modelos.length) {
            modelos[numModelos] = m;
            numModelos++;
        }

    }

    public void agregarFotografo(Fotografo f) {

        if (numFotografos < fotografos.length) {
            fotografos[numFotografos] = f;
            numFotografos++;
        }

    }

    public abstract String mostrarDetalles();

    public abstract String tipoEvento();
}