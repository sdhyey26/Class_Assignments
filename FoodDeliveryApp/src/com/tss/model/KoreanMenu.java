package com.tss.model;

import java.io.*;
import java.util.ArrayList;

public class KoreanMenu implements Serializable, IMenu {

    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "KoreanMenuList.ser";

    private String foodName;
    private double price;
    private String description;

    public KoreanMenu() {}

    public KoreanMenu(String foodName, double price, String description) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  ArrayList<KoreanMenu> getMenu() {
        ArrayList<KoreanMenu> menuList = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("No saved Korean menu found or file is empty.");
            return menuList;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                for (Object item : (ArrayList<?>) obj) {
                    if (item instanceof KoreanMenu) {
                        menuList.add((KoreanMenu) item);
                    } else {
                        System.out.println("Warning: Skipped non-KoreanMenu object.");
                    }
                }
            } else {
                System.out.println("Invalid data format: Expected ArrayList<KoreanMenu>");
            }
        } catch (EOFException e) {
            System.out.println("File is empty or corrupted (EOF reached unexpectedly).");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException while reading Korean menu file.");
            e.printStackTrace();
        }

        return menuList;
    }



    @Override
    public String toString() {
        return "[ foodName=" + foodName + ", price=" + price + ", description=" + description + " ]";
    }
}
