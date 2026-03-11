package persistencia;

import gestion.Lugar;

import java.io.*;
import java.util.ArrayList;

public class ArchivoLugares {

    private static final String ARCHIVO = "lugares.dat";

    public static void guardar(ArrayList<Lugar> lugares) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(lugares);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Lugar> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<Lugar>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de lugares aún.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
