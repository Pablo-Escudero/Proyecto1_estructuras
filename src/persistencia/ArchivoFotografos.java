package persistencia;

import modelos.Fotografo;

import java.io.*;
import java.util.ArrayList;

public class ArchivoFotografos {

    private static final String ARCHIVO = "fotografos.dat";

    public static void guardar(ArrayList<Fotografo> fotografos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(fotografos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Fotografo> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<Fotografo>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de fotografos aún.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
