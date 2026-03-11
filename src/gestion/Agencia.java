package gestion;

import modelos.Modelo;
import modelos.Fotografo;
import eventos.Evento;
import persistencia.*;

import java.util.ArrayList;

public class Agencia {

    private ArrayList<Modelo> modelos = new ArrayList<>();
    private ArrayList<Fotografo> fotografos = new ArrayList<>();
    private ArrayList<Lugar> lugares = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();

    public boolean agregarModelo(Modelo m) {
        for (Modelo modelo : modelos) {
            if (modelo.getIdentificacion().equals(m.getIdentificacion())) {
                return false;
            }
            if (modelo.getCodigoModelo().equals(m.getCodigoModelo())) {
                return false;
            }
        }
        modelos.add(m);
        return true;
    }

    public boolean existeModeloIdentificacion(String identificacion) {
        for (Modelo modelo : modelos) {
            if (modelo.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeModeloCodigo(String codigo) {
        for (Modelo modelo : modelos) {
            if (modelo.getCodigoModelo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Modelo> obtenerModelos() {
        return modelos;
    }

    public int getNumModelos() {
        return modelos.size();
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

    public boolean existeFotografoIdentificacion(String identificacion) {
        for (Fotografo fotografo : fotografos) {
            if (fotografo.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Fotografo> obtenerFotografos() {
        return fotografos;
    }

    public int getNumFotografos() {
        return fotografos.size();
    }

    public boolean agregarEvento(Evento e) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(e.getNombre())) {
                return false;
            }
        }
        eventos.add(e);
        return true;
    }

    public boolean existeEventoNombre(String nombre) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarEvento(int index) {
        if (index >= 0 && index < eventos.size()) {
            eventos.remove(index);
        }
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public int getNumEventos() {
        return eventos.size();
    }

    public boolean agregarLugar(Lugar l) {
        for (Lugar lugar : lugares) {
            if (lugar.getNombre().equals(l.getNombre())) {
                return false;
            }
        }
        lugares.add(l);
        return true;
    }

    public boolean existeLugarNombre(String nombre) {
        for (Lugar lugar : lugares) {
            if (lugar.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Lugar> obtenerLugares() {
        return lugares;
    }

    public int getNumLugares() {
        return lugares.size();
    }

    public Lugar buscarLugarPorNombre(String nombre) {
        for (Lugar lugar : lugares) {
            if (lugar.getNombre().equals(nombre)) {
                return lugar;
            }
        }
        return null;
    }

    public Modelo buscarModeloPorCodigo(String codigoModelo) {
        for (Modelo modelo : modelos) {
            if (modelo.getCodigoModelo().equals(codigoModelo)) {
                return modelo;
            }
        }
        return null;
    }

    public Fotografo buscarFotografoPorIdentificacion(String identificacion) {
        for (Fotografo fotografo : fotografos) {
            if (fotografo.getIdentificacion().equals(identificacion)) {
                return fotografo;
            }
        }
        return null;
    }

    public void guardarDatos() {
        ArchivoModelos.guardar(modelos);
        ArchivoFotografos.guardar(fotografos);
        ArchivoEventos.guardar(eventos);
        ArchivoLugares.guardar(lugares);
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        ArrayList<Modelo> modelosCargados = (ArrayList<Modelo>) ArchivoModelos.cargar();
        if (modelosCargados != null) modelos = modelosCargados;

        ArrayList<Fotografo> fotografosCargados = (ArrayList<Fotografo>) ArchivoFotografos.cargar();
        if (fotografosCargados != null) fotografos = fotografosCargados;

        ArrayList<Lugar> lugaresCargados = (ArrayList<Lugar>) ArchivoLugares.cargar();
        if (lugaresCargados != null) lugares = lugaresCargados;

        ArrayList<Evento> eventosCargados = (ArrayList<Evento>) ArchivoEventos.cargar();
        if (eventosCargados != null) eventos = eventosCargados;
    }
}
