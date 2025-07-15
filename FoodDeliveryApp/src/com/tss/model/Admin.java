package com.tss.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String ADMIN_FILE = "admin.ser";
    private static final String INDIAN_MENU_LIST_FILE = "IndianMenuList.ser";
    private static final String KOREAN_MENU_LIST_FILE = "KoreanMenuList.ser";
    private static final String ITALIAN_MENU_LIST_FILE = "ItalianMenuList.ser";
    private static final String AGENT_INFO = "agent.ser";

    private String name = "admin";
    private String password = "admin";

    public ArrayList<IndianMenu> indianMenuList = new ArrayList<>();
    public ArrayList<KoreanMenu> KoreanMenuList = new ArrayList<>();
    public ArrayList<ItalianMenu> italianMenuList = new ArrayList<>();
    private ArrayList<DeliveryAgents> agentsInfo = new ArrayList<>();
    private DeliveryAgents deliveryAgents;

    Discounts discount = new Discounts();

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
                if (obj instanceof AdminCredentials creds) {
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
        File fileOut = new File(ADMIN_FILE);
        try {
            if (!fileOut.exists()) {
               
                fileOut.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut))) {
                oos.writeObject(creds);
            }
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

    public void setIndianMenu(String name, double price, String description) {
        indianMenuList = loadObjectList(INDIAN_MENU_LIST_FILE, IndianMenu.class);

        IndianMenu menu = new IndianMenu();
        menu.setFoodName(name);
        menu.setPrice(price);
        menu.setDescription(description);
        indianMenuList.add(menu);
        System.out.println("Menu updated successfully!!");
        saveObjectList(indianMenuList, INDIAN_MENU_LIST_FILE);
    }

    public void setItalianMenu(String name, double price, String description) {
        italianMenuList = loadObjectList(ITALIAN_MENU_LIST_FILE, ItalianMenu.class);

        ItalianMenu menu = new ItalianMenu();
        menu.setFoodName(name);
        menu.setPrice(price);
        menu.setDescription(description);
        italianMenuList.add(menu);
        System.out.println("Menu updated successfully!!");

        saveObjectList(italianMenuList, ITALIAN_MENU_LIST_FILE);
    }

    public void setKoreanMenu(String name, double price, String description) {
        KoreanMenuList = loadObjectList(KOREAN_MENU_LIST_FILE, KoreanMenu.class);

        KoreanMenu menu = new KoreanMenu();
        menu.setFoodName(name);
        menu.setPrice(price);
        menu.setDescription(description);
        KoreanMenuList.add(menu);
        System.out.println("Menu updated successfully!!");

        saveObjectList(KoreanMenuList, KOREAN_MENU_LIST_FILE);
    }

    public void setDeliveryAgent() {
        Scanner sc = new Scanner(System.in);
        agentsInfo = loadObjectList(AGENT_INFO, DeliveryAgents.class);
        for (int i = 0; i < 2; i++) {
            deliveryAgents = new DeliveryAgents();
            System.out.print("Enter agent name: ");
            deliveryAgents.setName(sc.nextLine());
            agentsInfo.add(deliveryAgents);
        }
        saveObjectList(agentsInfo, AGENT_INFO);
    }

    public ArrayList<DeliveryAgents> getDeliveryAgent() {
        agentsInfo = loadObjectList(AGENT_INFO, DeliveryAgents.class);
        return agentsInfo;
    }

    public void changeDiscountPercentage(int choice) {
        discount.setDiscountPercentage(choice);
    }

    public int getDiscountPercentage() {
        return discount.getDiscountPercentage();
    }

    private void saveObjectList(Object list, String filePath) {
        File fileOut = new File(filePath);
        try {
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut))) {
                oos.writeObject(list);
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + filePath);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private <T> ArrayList<T> loadObjectList(String filePath, Class<T> clazz) {
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?> list) {
                    ArrayList<T> typedList = new ArrayList<>();
                    for (Object item : list) {
                        if (clazz.isInstance(item)) {
                            typedList.add((T) item);
                        }
                    }
                    return typedList;
                }
            } catch (EOFException e) {
                System.out.println("Empty file: " + filePath);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
