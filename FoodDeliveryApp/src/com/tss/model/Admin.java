package com.tss.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin implements Serializable {
	Discounts discount = new Discounts();
	DeliveryAgents deliveryAgents;
	ArrayList<DeliveryAgents> agentsInfo = new ArrayList<>();

	
    private static final long serialVersionUID = 1L;
    private static final String ADMIN_FILE = "admin.ser";
    private static final String MENU_LIST_FILE = "menuList.ser";
    private static final String AGENT_INFO = "agent.ser";

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
        
        discount.setDiscountPercentage(choice);
    }
    
    public int getDiscountPercentage() {
    	return discount.getDiscountPercentage();
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
    
    public void setDeliveryAgent() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
        	deliveryAgents = new DeliveryAgents();
            System.out.println("Enter agent name: ");
            String name = sc.nextLine();
            deliveryAgents.setName(name);

            agentsInfo.add(deliveryAgents);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AGENT_INFO))) {
            oos.writeObject(agentsInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public ArrayList<DeliveryAgents> getDeliveryAgent() {
    	File file = new File(AGENT_INFO);
        if (!file.exists()) {
        	agentsInfo = new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
            	agentsInfo = (ArrayList<DeliveryAgents>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            agentsInfo = new ArrayList<>();
        }
		return agentsInfo;
    }
}
