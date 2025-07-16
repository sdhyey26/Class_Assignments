package com.tss.model.admin.storage;

import java.io.*;
import java.util.ArrayList;

public class FileStorage {
    public static <T> void saveListToFile(ArrayList<T> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> ArrayList<T> loadListFromFile(String fileName, Class<T> clazz) {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?> rawList) {
                    ArrayList<T> typedList = new ArrayList<>();
                    for (Object item : rawList) {
                        if (clazz.isInstance(item)) {
                            typedList.add(clazz.cast(item));
                        }
                    }
                    return typedList;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
