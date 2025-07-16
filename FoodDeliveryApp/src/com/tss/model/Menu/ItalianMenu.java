package com.tss.model.Menu;

import java.io.*;
import java.util.ArrayList;

public class ItalianMenu implements Serializable, IMenu {

    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "ItalianMenuList.ser";

    private String foodName;
    private double price;
    private String description;

    public ItalianMenu() {}

    public ItalianMenu(String foodName, double price, String description) {
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

    public ArrayList<ItalianMenu> getMenu() {
        ArrayList<ItalianMenu> menuList = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("No saved Italian menu found or file is empty.");
            return menuList;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                for (Object item : (ArrayList<?>) obj) {
                    if (item instanceof ItalianMenu) {
                        menuList.add((ItalianMenu) item);
                    } else {
                        System.out.println("Warning: Skipping non-ItalianMenu object.");
                    }
                }
            } else {
                System.out.println("Invalid menu format in file.");
            }
        } catch (EOFException e) {
            System.out.println("Reached end of file unexpectedly. The file might be corrupted.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException occurred while reading Italian menu file.");
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public String toString() {
        return String.format("%-25s ₹%7.2f   %s", foodName, price, description);
    }

}
