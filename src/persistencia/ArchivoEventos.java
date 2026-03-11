package persistencia;

import eventos.Evento;

import java.io.*;
import java.util.ArrayList;

public class ArchivoEventos {

    private static final String ARCHIVO = "eventos.dat";

    public static void guardar(ArrayList<Evento> eventos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Evento> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<Evento>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de eventos aún.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
