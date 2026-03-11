package gui;

import gestion.Agencia;
import gestion.Lugar;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelLugar extends JPanel {

    private Agencia agencia;

    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtCiudad;
    private JTextField txtCapacidad;
    private JTextField txtTipoLugar;
    private JTextArea area;

    public PanelLugar(Agencia agencia){

        this.agencia = agencia;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JPanel form = new JPanel(new GridLayout(5,2,5,5));
        form.setBorder(new TitledBorder("Registro de lugares"));
        form.setBackground(Color.WHITE);

        txtNombre = new JTextField();
        txtDireccion = new JTextField();
        txtCiudad = new JTextField();
        txtCapacidad = new JTextField();
        txtTipoLugar = new JTextField();

        form.add(new JLabel("Nombre Lugar"));
        form.add(txtNombre);

        form.add(new JLabel("Dirección"));
        form.add(txtDireccion);

        form.add(new JLabel("Ciudad"));
        form.add(txtCiudad);

        form.add(new JLabel("Capacidad"));
        form.add(txtCapacidad);

        form.add(new JLabel("Tipo de lugar"));
        form.add(txtTipoLugar);

        JButton btn = new JButton("Registrar Lugar");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btn);

        add(panelBoton, BorderLayout.SOUTH);

        add(form,BorderLayout.NORTH);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(new TitledBorder("Lugares registrados"));
        add(scroll,BorderLayout.CENTER);

        btn.addActionListener(e -> registrarLugar());

        cargarLugaresExistentes();
    }

    private void registrarLugar(){

        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String ciudad = txtCiudad.getText();
        String tipo = txtTipoLugar.getText();

        int capacidad;
        try {
            capacidad = Integer.parseInt(txtCapacidad.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una capacidad numérica válida");
            return;
        }

        if (agencia.existeLugarNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "Ya existe un lugar con ese nombre.");
            return;
        }

        Lugar l = new Lugar(
                nombre,
                direccion,
                ciudad,
                capacidad,
                tipo
        );

        agencia.agregarLugar(l);

        area.append(l.mostrarLugar()+"\n");

    }

    private void cargarLugaresExistentes() {
        for (Lugar lugar : agencia.obtenerLugares()) {
            area.append(lugar.mostrarLugar() + "\n");
        }
    }
}