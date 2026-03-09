package persistencia;

import modelos.Modelo;
import gestion.Agencia;

import java.io.*;

public class ArchivoModelos {

    public static void guardar(Modelo[] modelos, int cantidad) {

        try {

            FileWriter writer = new FileWriter("modelos.txt");

            for (int i = 0; i < cantidad; i++) {

                writer.write(modelos[i].toArchivo() + "\n");

            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void cargar(Agencia agencia) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("modelos.txt"));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length < 7) {
                    continue;
                }

                String nombre = datos[0];
                String identificacion = datos[1];
                String contacto = datos[2];
                String codigoModelo = datos[3];
                double estatura = Double.parseDouble(datos[4]);
                String categoria = datos[5];
                boolean disponible = Boolean.parseBoolean(datos[6]);

                Modelo modelo = new Modelo(
                        nombre,
                        identificacion,
                        contacto,
                        codigoModelo,
                        estatura,
                        categoria,
                        disponible
                );

                agencia.agregarModelo(modelo);

            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No hay archivo de modelos aún.");
        }

    }
}