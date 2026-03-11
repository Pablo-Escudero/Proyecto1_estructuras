package eventos;

import gestion.Lugar;
import modelos.Modelo;
import modelos.Fotografo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String nombreEvento;
    protected String fecha;
    protected Lugar lugar;

    protected ArrayList<Modelo> modelos = new ArrayList<>();
    protected ArrayList<Fotografo> fotografos = new ArrayList<>();

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

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public int getNumModelos() {
        return modelos.size();
    }

    public ArrayList<Fotografo> getFotografos() {
        return fotografos;
    }

    public int getNumFotografos() {
        return fotografos.size();
    }

    public boolean agregarModelo(Modelo m) {
        for (Modelo modelo : modelos) {
            if (modelo.getCodigoModelo().equals(m.getCodigoModelo())) {
                return false;
            }
        }
        modelos.add(m);
        return true;
    }

    public boolean agregarFotografo(Fotografo f) {
        for (Fotografo fotografo : fotografos) {
            if (fotografo.getIdentificacion().equals(f.getIdentificacion())) {
                return false;
            }
        }
        fotografos.add(f);
        return true;
    }

    public abstract String mostrarDetalles();

    public abstract String tipoEvento();
}