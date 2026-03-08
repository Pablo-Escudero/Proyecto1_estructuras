package gestion;

import modelos.Modelo;
import modelos.Fotografo;
import eventos.Evento;
import persistencia.*;

public class Agencia {

    private Modelo[] modelos = new Modelo[100];
    private Fotografo[] fotografos = new Fotografo[50];
    private Lugar[] lugares = new Lugar[20];
    private Evento[] eventos = new Evento[100];

    private int numModelos = 0;
    private int numFotografos = 0;
    private int numLugares = 0;
    private int numEventos = 0;

    public void agregarModelo(Modelo m) {
        if (numModelos < modelos.length) {
            modelos[numModelos++] = m;
        }
    }

    public Modelo[] obtenerModelos() {
        return modelos;
    }

    public int getNumModelos() {
        return numModelos;
    }

    public void agregarFotografo(Fotografo f) {
        if (numFotografos < fotografos.length) {
            fotografos[numFotografos++] = f;
        }
    }

    public Fotografo[] obtenerFotografos() {
        return fotografos;
    }

    public int getNumFotografos() {
        return numFotografos;
    }

    public void agregarEvento(Evento e) {
        if (numEventos < eventos.length) {
            eventos[numEventos++] = e;
        }
    }

    public void eliminarEvento(int index) {
        if (index >= 0 && index < numEventos) {
            for (int i = index; i < numEventos - 1; i++) {
                eventos[i] = eventos[i + 1];
            }
            eventos[numEventos - 1] = null;
            numEventos--;
        }
    }

    public Evento[] getEventos() {
        return eventos;
    }

    public int getNumEventos() {
        return numEventos;
    }

    public void agregarLugar(Lugar l) {
        if (numLugares < lugares.length) {
            lugares[numLugares++] = l;
        }
    }

    public Lugar[] obtenerLugares() {
        return lugares;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public Lugar buscarLugarPorNombre(String nombre) {
        for (int i = 0; i < numLugares; i++) {
            if (lugares[i] != null && lugares[i].getNombre().equals(nombre)) {
                return lugares[i];
            }
        }
        return null;
    }

    public Modelo buscarModeloPorCodigo(String codigoModelo) {
        for (int i = 0; i < numModelos; i++) {
            if (modelos[i] != null && modelos[i].getCodigoModelo().equals(codigoModelo)) {
                return modelos[i];
            }
        }
        return null;
    }

    public Fotografo buscarFotografoPorIdentificacion(String identificacion) {
        for (int i = 0; i < numFotografos; i++) {
            if (fotografos[i] != null && fotografos[i].getIdentificacion().equals(identificacion)) {
                return fotografos[i];
            }
        }
        return null;
    }

    public void guardarDatos() {

        ArchivoModelos.guardar(modelos, numModelos);
        ArchivoFotografos.guardar(fotografos, numFotografos);
        ArchivoEventos.guardar(eventos, numEventos);
        ArchivoLugares.guardar(lugares, numLugares);

    }

    public void cargarDatos() {

        ArchivoModelos.cargar(this);
        ArchivoFotografos.cargar(this);
        ArchivoLugares.cargar(this);
        ArchivoEventos.cargar(this);

    }

}