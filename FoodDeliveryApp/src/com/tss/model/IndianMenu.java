package com.tss.model;

import java.io.*;
import java.util.ArrayList;

public class IndianMenu implements Serializable,IMenu {

    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "IndianMenuList.ser";

    private String foodName;
    private double price;
    private String description;

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


    public ArrayList<IndianMenu> getMenu() {
        ArrayList<IndianMenu> menuList = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("No saved menu list found or file is empty.");
            return menuList;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();

            if (obj instanceof ArrayList<?>) {
                ArrayList<?> rawList = (ArrayList<?>) obj;
                for (Object item : rawList) {
                    if (item instanceof IndianMenu) {
                        menuList.add((IndianMenu) item);
                    } else {
                        System.out.println("Warning: Skipped non-IndianMenu object.");
                    }
                }
            } else {
                System.out.println("Invalid data format in file.");
            }
        } catch (EOFException e) {
            System.out.println("File is empty or corrupted.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found while reading menu.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException occurred while reading menu file.");
            e.printStackTrace();
        }

        return menuList;
    }


    
    @Override
    public String toString() {
        return String.format("%-25s ₹%7.2f   %s", foodName, price, description);
    }

}
