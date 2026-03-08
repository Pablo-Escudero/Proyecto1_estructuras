package persistencia;

import gestion.Lugar;
import gestion.Agencia;

import java.io.*;

public class ArchivoLugares {

    public static void guardar(Lugar[] lugares, int cantidad) {

        try {

            FileWriter writer = new FileWriter("lugares.txt");

            for (int i = 0; i < cantidad; i++) {

                writer.write(lugares[i].toArchivo() + "\n");

            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void cargar(Agencia agencia) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("lugares.txt"));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length < 5) {
                    continue;
                }

                String nombre = datos[0];
                String direccion = datos[1];
                String ciudad = datos[2];
                int capacidad = Integer.parseInt(datos[3]);
                String tipoLugar = datos[4];

                Lugar lugar = new Lugar(nombre, direccion, ciudad, capacidad, tipoLugar);

                agencia.agregarLugar(lugar);

            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No hay archivo de lugares aún.");
        }

    }
}