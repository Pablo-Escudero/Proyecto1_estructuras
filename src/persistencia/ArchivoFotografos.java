package persistencia;

import modelos.Fotografo;
import gestion.Agencia;

import java.io.*;

public class ArchivoFotografos {

    public static void guardar(Fotografo[] fotografos, int cantidad) {

        try {

            FileWriter writer = new FileWriter("fotografos.txt");

            for (int i = 0; i < cantidad; i++) {

                writer.write(
                        fotografos[i].getNombre() + "," +
                                fotografos[i].getIdentificacion() + "," +
                                fotografos[i].getContacto() + "," +
                                fotografos[i].getEspecialidad() + "," +
                                fotografos[i].getAnosExperiencia() + "\n"
                );

            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void cargar(Agencia agencia) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("fotografos.txt"));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length < 5) {
                    continue;
                }

                String nombre = datos[0];
                String identificacion = datos[1];
                String contacto = datos[2];
                String especialidad = datos[3];
                int aniosExperiencia = Integer.parseInt(datos[4]);

                Fotografo f = new Fotografo(
                        nombre,
                        identificacion,
                        contacto,
                        especialidad,
                        aniosExperiencia
                );

                agencia.agregarFotografo(f);

            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No hay archivo de fotografos aún.");
        }

    }

}