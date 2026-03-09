package gui;

import gestion.Agencia;
import gestion.Lugar;
import eventos.Evento;
import eventos.EventoPublico;
import eventos.EventoPrivado;
import modelos.Modelo;
import modelos.Fotografo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelEvento extends JPanel {

    private Agencia agencia;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public PanelEvento(Agencia agencia) {

        this.agencia = agencia;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Gestión de eventos", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);

        JButton btnCrear = new JButton("Crear evento");
        JButton btnEliminar = new JButton("Eliminar evento");
        JButton btnAsignar = new JButton("Asignar participantes");
        JButton btnDetalles = new JButton("Ver detalles");

        panelBotones.add(btnCrear);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnAsignar);
        panelBotones.add(btnDetalles);

        add(panelBotones, BorderLayout.SOUTH);

        modeloTabla = new DefaultTableModel(
                new String[]{"Nombre", "Fecha", "Lugar"},
                0
        );

        tabla = new JTable(modeloTabla);
        tabla.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(new TitledBorder("Listado de eventos"));

        add(scroll, BorderLayout.CENTER);

        btnCrear.addActionListener(e -> crearEvento());
        btnEliminar.addActionListener(e -> eliminarEvento());
        btnAsignar.addActionListener(e -> asignarParticipantes());
        btnDetalles.addActionListener(e -> mostrarDetalles());

        actualizarTabla();
    }

    private void crearEvento() {

        String nombre = JOptionPane.showInputDialog(this, "Nombre del evento:");
        if (nombre == null || nombre.isEmpty()) return;

        String fecha = JOptionPane.showInputDialog(this, "Fecha del evento:");
        if (fecha == null || fecha.isEmpty()) return;

        Lugar[] lugares = agencia.obtenerLugares();
        int numLugares = agencia.getNumLugares();
        if (numLugares == 0) {
            JOptionPane.showMessageDialog(this, "No hay lugares registrados. Registre un lugar primero.");
            return;
        }

        String[] nombresLugares = new String[numLugares];
        for (int i = 0; i < numLugares; i++) {
            nombresLugares[i] = lugares[i].getNombre();
        }

        String nombreLugar = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el lugar:",
                "Lugar",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresLugares,
                nombresLugares[0]
        );
        if (nombreLugar == null || nombreLugar.isEmpty()) return;

        Lugar lugar = agencia.buscarLugarPorNombre(nombreLugar);

        String[] opciones = {"Publico", "Privado"};

        String tipo = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione tipo de evento:",
                "Tipo Evento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (tipo == null) return;

        Evento evento;

        if (tipo.equals("Publico")) {

            String patrocinador = JOptionPane.showInputDialog(this, "Patrocinador:");
            if (patrocinador == null) return;

            int capacidad = Integer.parseInt(
                    JOptionPane.showInputDialog(this, "Capacidad de asistentes:")
            );

            evento = new EventoPublico(
                    nombre,
                    fecha,
                    lugar,
                    capacidad,
                    patrocinador
            );

        } else {

            String cliente = JOptionPane.showInputDialog(this, "Cliente:");
            if (cliente == null) return;

            String nivel = JOptionPane.showInputDialog(this, "Nivel de confidencialidad:");
            if (nivel == null) return;

            evento = new EventoPrivado(
                    nombre,
                    fecha,
                    lugar,
                    cliente,
                    nivel
            );

        }

        agencia.agregarEvento(evento);

        actualizarTabla();
    }

    private void eliminarEvento() {

        int fila = tabla.getSelectedRow();

        if (fila >= 0) {

            agencia.eliminarEvento(fila);

            actualizarTabla();

        } else {

            JOptionPane.showMessageDialog(this, "Seleccione un evento");

        }
    }

    private void actualizarTabla() {

        modeloTabla.setRowCount(0);

        Evento[] eventos = agencia.getEventos();
        int numEventos = agencia.getNumEventos();

        for (int i = 0; i < numEventos; i++) {
            Evento e = eventos[i];
            if (e != null) {
                modeloTabla.addRow(new Object[]{
                        e.getNombre(),
                        e.getFecha(),
                        e.getLugar().getNombre()
                });
            }
        }
    }

    private void asignarParticipantes() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento");
            return;
        }

        Evento evento = agencia.getEventos()[fila];
        if (evento == null) return;

        Modelo[] modelos = agencia.obtenerModelos();
        int numModelos = agencia.getNumModelos();
        if (numModelos > 0) {
            String[] nombresModelos = new String[numModelos];
            for (int i = 0; i < numModelos; i++) {
                nombresModelos[i] = modelos[i].getNombre() + " (" + modelos[i].getCodigoModelo() + ")";
            }

            String seleccionado = (String) JOptionPane.showInputDialog(
                    this,
                    "Seleccione un modelo para asignar:",
                    "Asignar modelo",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombresModelos,
                    nombresModelos[0]
            );

            if (seleccionado != null) {
                int indice = 0;
                for (int i = 0; i < numModelos; i++) {
                    if (nombresModelos[i].equals(seleccionado)) {
                        indice = i;
                        break;
                    }
                }
                evento.agregarModelo(modelos[indice]);
            }
        }

        Fotografo[] fotografos = agencia.obtenerFotografos();
        int numFotografos = agencia.getNumFotografos();
        if (numFotografos > 0) {
            String[] nombresFotografos = new String[numFotografos];
            for (int i = 0; i < numFotografos; i++) {
                nombresFotografos[i] = fotografos[i].getNombre();
            }

            String seleccionadoF = (String) JOptionPane.showInputDialog(
                    this,
                    "Seleccione un fotógrafo para asignar:",
                    "Asignar fotógrafo",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombresFotografos,
                    nombresFotografos[0]
            );

            if (seleccionadoF != null) {
                int indiceF = 0;
                for (int i = 0; i < numFotografos; i++) {
                    if (nombresFotografos[i].equals(seleccionadoF)) {
                        indiceF = i;
                        break;
                    }
                }
                evento.agregarFotografo(fotografos[indiceF]);
            }
        }
    }

    private void mostrarDetalles() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento");
            return;
        }

        Evento evento = agencia.getEventos()[fila];
        if (evento == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append(evento.mostrarDetalles()).append("\n");
        sb.append("Modelos asignados: ").append(evento.getNumModelos()).append("\n");
        sb.append("Fotógrafos asignados: ").append(evento.getNumFotografos()).append("\n");

        JOptionPane.showMessageDialog(this, sb.toString(), "Detalles del evento", JOptionPane.INFORMATION_MESSAGE);
    }
}