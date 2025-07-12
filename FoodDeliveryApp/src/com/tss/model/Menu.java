package com.tss.model;

import java.io.*;
import java.util.ArrayList;

public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "menuList.ser";

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





    public ArrayList<Menu> getMenu() {
        ArrayList<Menu> menuList = new ArrayList<>();
        File file = new File("menuList.ser");

        if (!file.exists()) {
            System.out.println("No saved menu list found.");
            return menuList;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                for (Object item : (ArrayList<?>) obj) {
                    if (item instanceof Menu) {
                        menuList.add((Menu) item);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return menuList;
    }

    
    @Override
    public String toString() {
        return "Menu [foodName=" + foodName + ", price=" + price + ", description=" + description + "]";
    }
}
