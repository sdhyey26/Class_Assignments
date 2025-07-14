package com.tss.model;

import java.io.*;
import java.util.ArrayList;

public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String ADMIN_FILE = "admin.ser";
    private static final String MENU_LIST_FILE = "menuList.ser";

    public ArrayList<Menu> menuList = new ArrayList<>();

    private String name = "admin";
    private String password = "admin"; 

    private static class AdminCredentials implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        String password;

        AdminCredentials(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

    public Admin() {
        loadAdminCredentials(); 
    }

    private void loadAdminCredentials() {
        File file = new File(ADMIN_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof AdminCredentials) {
                    AdminCredentials creds = (AdminCredentials) obj;
                    this.name = creds.name;
                    this.password = creds.password;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            saveAdminCredentials(); 
        }
    }

    private void saveAdminCredentials() {
        AdminCredentials creds = new AdminCredentials(this.name, this.password);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADMIN_FILE))) {
            oos.writeObject(creds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        loadAdminCredentials();
        return name;
    }

    public void setName(String name) {
        this.name = name;
        saveAdminCredentials();
    }

    public String getPassword() {
        loadAdminCredentials();
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        saveAdminCredentials();
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
        File file = new File(MENU_LIST_FILE);
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
