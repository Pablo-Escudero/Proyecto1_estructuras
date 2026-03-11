package gui;

import gestion.Agencia;
import modelos.Fotografo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelFotografo extends JPanel {

    private Agencia agencia;

    private JTextField txtNombre;
    private JTextField txtIdentificacion;
    private JTextField txtContacto;
    private JTextField txtEspecialidad;
    private JTextField txtExperiencia;
    private JTextArea area;

    public PanelFotografo(Agencia agencia) {

        this.agencia = agencia;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.setBorder(new TitledBorder("Registro de fotógrafos"));
        form.setBackground(Color.WHITE);

        txtNombre = new JTextField();
        txtIdentificacion = new JTextField();
        txtContacto = new JTextField();
        txtEspecialidad = new JTextField();
        txtExperiencia = new JTextField();

        form.add(new JLabel("Nombre"));
        form.add(txtNombre);

        form.add(new JLabel("Identificación"));
        form.add(txtIdentificacion);

        form.add(new JLabel("Contacto"));
        form.add(txtContacto);

        form.add(new JLabel("Especialidad"));
        form.add(txtEspecialidad);

        form.add(new JLabel("Años de experiencia"));
        form.add(txtExperiencia);

        JButton btn = new JButton("Registrar Fotógrafo");
        form.add(btn);

        add(form, BorderLayout.NORTH);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(new TitledBorder("Fotógrafos registrados"));
        add(scroll, BorderLayout.CENTER);

        btn.addActionListener(e -> registrarFotografo());

        cargarFotografosExistentes();
    }

    private void registrarFotografo() {

        String nombre = txtNombre.getText();
        String identificacion = txtIdentificacion.getText();
        String contacto = txtContacto.getText();
        String especialidad = txtEspecialidad.getText();

        int experiencia;
        try {
            experiencia = Integer.parseInt(txtExperiencia.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de años de experiencia");
            return;
        }

        if (agencia.existeFotografoIdentificacion(identificacion)) {
            JOptionPane.showMessageDialog(this, "Ya existe un fotógrafo con esa identificación.");
            return;
        }

        Fotografo f = new Fotografo(
                nombre,
                identificacion,
                contacto,
                especialidad,
                experiencia
        );

        agencia.agregarFotografo(f);

        area.append(f.mostrarInformacion() + "\n");
    }

    private void cargarFotografosExistentes() {
        Fotografo[] fotografos = agencia.obtenerFotografos();
        int cantidad = agencia.getNumFotografos();

        for (int i = 0; i < cantidad; i++) {
            if (fotografos[i] != null) {
                area.append(fotografos[i].mostrarInformacion() + "\n");
            }
        }
    }
}