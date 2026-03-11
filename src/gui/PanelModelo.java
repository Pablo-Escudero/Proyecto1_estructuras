package gui;

import gestion.Agencia;
import modelos.Modelo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelModelo extends JPanel {

    private Agencia agencia;
    private JTextField txtNombre;
    private JTextField txtIdentificacion;
    private JTextField txtContacto;
    private JTextField txtCodigo;
    private JTextField txtEstatura;
    private JTextField txtCategoria;
    private JCheckBox chkDisponible;
    private JTextArea area;

    public PanelModelo(Agencia agencia) {

        this.agencia = agencia;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JPanel form = new JPanel(new GridLayout(8, 2, 5, 5));
        form.setBorder(new TitledBorder("Registro de modelos"));
        form.setBackground(Color.WHITE);

        txtNombre = new JTextField();
        txtIdentificacion = new JTextField();
        txtContacto = new JTextField();
        txtCodigo = new JTextField();
        txtEstatura = new JTextField();
        txtCategoria = new JTextField();
        chkDisponible = new JCheckBox("Disponible", true);
        chkDisponible.setBackground(Color.WHITE);

        form.add(new JLabel("Nombre"));
        form.add(txtNombre);

        form.add(new JLabel("Identificación"));
        form.add(txtIdentificacion);

        form.add(new JLabel("Contacto"));
        form.add(txtContacto);

        form.add(new JLabel("Código modelo"));
        form.add(txtCodigo);

        form.add(new JLabel("Estatura (m)"));
        form.add(txtEstatura);

        form.add(new JLabel("Categoría"));
        form.add(txtCategoria);

        form.add(new JLabel(""));
        form.add(chkDisponible);

        JButton btn = new JButton("Registrar Modelo");

        form.add(btn);

        add(form, BorderLayout.NORTH);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(new TitledBorder("Modelos registrados"));
        add(scroll, BorderLayout.CENTER);

        btn.addActionListener(e -> registrarModelo());

        cargarModelosExistentes();
    }

    private void registrarModelo(){

        String nombre = txtNombre.getText();
        String identificacion = txtIdentificacion.getText();
        String contacto = txtContacto.getText();
        String codigo = txtCodigo.getText();
        String categoria = txtCategoria.getText();
        boolean disponible = chkDisponible.isSelected();

        double estatura;
        try {
            estatura = Double.parseDouble(txtEstatura.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una estatura válida (por ejemplo 1.75)");
            return;
        }

        if (estatura < 1.60) {
            JOptionPane.showMessageDialog(this, "La estatura mínima permitida es 1.60 m");
            return;
        }

        if (agencia.existeModeloIdentificacion(identificacion)) {
            JOptionPane.showMessageDialog(this, "Ya existe un modelo con esa identificación.");
            return;
        }

        if (agencia.existeModeloCodigo(codigo)) {
            JOptionPane.showMessageDialog(this, "Ya existe un modelo con ese código.");
            return;
        }

        Modelo m = new Modelo(
                nombre,
                identificacion,
                contacto,
                codigo,
                estatura,
                categoria,
                disponible
        );

        agencia.agregarModelo(m);

        area.append(m.mostrarInformacion()+"\n");
    }

    private void cargarModelosExistentes() {
        Modelo[] modelos = agencia.obtenerModelos();
        int cantidad = agencia.getNumModelos();

        for (int i = 0; i < cantidad; i++) {
            if (modelos[i] != null) {
                area.append(modelos[i].mostrarInformacion() + "\n");
            }
        }
    }
}