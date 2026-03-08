package persistencia;

import eventos.*;
import gestion.Agencia;
import gestion.Lugar;

import java.io.*;

public class ArchivoEventos {

    public static void guardar(Evento[] eventos, int cantidad) {

        try {

            FileWriter writer = new FileWriter("eventos.txt");

            for (int i = 0; i < cantidad; i++) {

                Evento e = eventos[i];

                if (e instanceof EventoPublico) {
                    EventoPublico ep = (EventoPublico) e;
                    writer.write(
                            ep.tipoEvento() + "," +
                                    ep.getNombre() + "," +
                                    ep.getFecha() + "," +
                                    ep.getLugar().getNombre() + "," +
                                    ep.getCapacidadAsistentes() + "," +
                                    ep.getPatrocinador() + "\n"
                    );
                } else if (e instanceof EventoPrivado) {
                    EventoPrivado ev = (EventoPrivado) e;
                    writer.write(
                            ev.tipoEvento() + "," +
                                    ev.getNombre() + "," +
                                    ev.getFecha() + "," +
                                    ev.getLugar().getNombre() + "," +
                                    ev.getCliente() + "," +
                                    ev.getNivelConfidencialidad() + "\n"
                    );
                }

            }

            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void cargar(Agencia agencia) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("eventos.txt"));

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length < 4) {
                    continue;
                }

                String tipo = datos[0];
                String nombre = datos[1];
                String fecha = datos[2];
                String nombreLugar = datos[3];

                Lugar lugar = agencia.buscarLugarPorNombre(nombreLugar);
                if (lugar == null) {
                    lugar = new Lugar(nombreLugar, "", "", 0, "");
                }

                Evento evento;

                if (tipo.equals("Publico")) {
                    int capacidad = 0;
                    String patrocinador = "";
                    if (datos.length >= 6) {
                        capacidad = Integer.parseInt(datos[4]);
                        patrocinador = datos[5];
                    }
                    evento = new EventoPublico(nombre, fecha, lugar, capacidad, patrocinador);
                } else {
                    String cliente = "";
                    String nivel = "";
                    if (datos.length >= 6) {
                        cliente = datos[4];
                        nivel = datos[5];
                    }
                    evento = new EventoPrivado(nombre, fecha, lugar, cliente, nivel);
                }

                agencia.agregarEvento(evento);

            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No hay archivo de eventos aún.");
        }

    }
}