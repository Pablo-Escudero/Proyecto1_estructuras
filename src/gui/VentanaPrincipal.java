package gui;

import gestion.Agencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {

    private Agencia agencia;
    private static final Color FONDO_GRIS = new Color(40, 40, 40);
    private static final Color DORADO = new Color(212, 175, 55);
    private static final Color NEGRO = Color.BLACK;

    public VentanaPrincipal() {

        agencia = new Agencia();
        agencia.cargarDatos();

        setTitle("Sistema Agencia de Modelaje");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(FONDO_GRIS);
        setLayout(new BorderLayout());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(FONDO_GRIS);
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ImageIcon iconoOriginal = new ImageIcon("NoMasEnanosPorfavor.png");
        JLabel lblImagen;
        if (iconoOriginal.getIconWidth() > 0) {
            int maxAlto = 80;
            int anchoOriginal = iconoOriginal.getIconWidth();
            int altoOriginal = iconoOriginal.getIconHeight();
            double factor = (double) maxAlto / altoOriginal;
            int nuevoAncho = (int) (anchoOriginal * factor);

            Image imgEscalada = iconoOriginal.getImage().getScaledInstance(
                    nuevoAncho,
                    maxAlto,
                    Image.SCALE_SMOOTH
            );
            ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
            lblImagen = new JLabel(iconoEscalado);
        } else {
            lblImagen = new JLabel();
        }

        JLabel lblTitulo = new JLabel("Agencia de Modelaje \"No Más Enanos Por Favor\"");
        lblTitulo.setForeground(DORADO);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(lblImagen, BorderLayout.WEST);
        header.add(lblTitulo, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabs.setBackground(FONDO_GRIS);
        tabs.setForeground(DORADO);

        tabs.add("Modelos", new PanelModelo(agencia));
        tabs.add("Fotógrafos", new PanelFotografo(agencia));
        tabs.add("Eventos", new PanelEvento(agencia));
        tabs.add("Lugares", new PanelLugar(agencia));

        add(tabs, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                agencia.guardarDatos();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}