package persistencia;

import modelos.Modelo;

import java.io.*;
import java.util.ArrayList;

public class ArchivoModelos {

    private static final String ARCHIVO = "modelos.dat";

    public static void guardar(ArrayList<Modelo> modelos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(modelos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Modelo> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<Modelo>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de modelos aún.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
