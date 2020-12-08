package domain.utils;

import java.io.*;

public class SerializationUtils {

    public static void saveInfo(Object object, String filename) {

        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            System.out.println("Информация сохранена");
            oos.writeObject(object);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static Object loadInfo(String filename) {
        Object loadObject = null;
        try (FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis)){
            loadObject = ois.readObject();
        } catch (ClassNotFoundException | IOException exception) {
            System.out.println("Существующих задач нет");
        }
        return loadObject;
    }
}
