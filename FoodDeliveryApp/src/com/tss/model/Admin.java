package com.tss.model;

import java.io.*;
import java.util.ArrayList;

public class Admin implements Serializable {

    public ArrayList<Menu> menuList = new ArrayList<>();

    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "admin.txt";
    private static final String MENU_LIST_FILE = "menuList.ser"; 

    private String name;
    private int password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof Integer) {
                password = (int) obj;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return password;
    }

    public void setPassword(int password) {
        this.password = password;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMenu(String name, double price, String description) {
        deserializeMenuList(); 

        Menu menu = new Menu();
        menu.setDescription(description);
        menu.setFoodName(name);
        menu.setPrice(price);

        menuList.add(menu);
        serializeMenuList(); 
    }


    public void changeDiscountPercentage(int choice) {
        Discounts discount = new Discounts();
        discount.setDiscountPercentage(choice);
    }

    public void serializeMenuList() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MENU_LIST_FILE))) {
            oos.writeObject(menuList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private void deserializeMenuList() {
        File file = new File("menuList.ser");

        if (!file.exists()) {
            menuList = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                menuList = (ArrayList<Menu>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            menuList = new ArrayList<>(); 
        }
    }

}
