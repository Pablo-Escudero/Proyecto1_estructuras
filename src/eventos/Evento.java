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

    public boolean agregarModelo(Modelo m) {
        if (numModelos >= modelos.length) {
            return false;
        }
        for (int i = 0; i < numModelos; i++) {
            if (modelos[i] != null && modelos[i].getCodigoModelo().equals(m.getCodigoModelo())) {
                return false;
            }
        }
        modelos[numModelos++] = m;
        return true;
    }

    public boolean agregarFotografo(Fotografo f) {
        if (numFotografos >= fotografos.length) {
            return false;
        }
        for (int i = 0; i < numFotografos; i++) {
            if (fotografos[i] != null && fotografos[i].getIdentificacion().equals(f.getIdentificacion())) {
                return false;
            }
        }
        fotografos[numFotografos++] = f;
        return true;
    }

    public abstract String mostrarDetalles();

    public abstract String tipoEvento();
}