package com.tss.model.admin.discount;

import java.io.*;

public class DiscountManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String DISCOUNT_FILE = "discount.ser";

    private int discountPercentage = 10; 

    public DiscountManager() {
        loadDiscount();
    }

    public void setDiscountPercentage(int value) {
        this.discountPercentage = value;
        saveDiscount();
    }

    public int getDiscountPercentage() {
        loadDiscount();
        return this.discountPercentage;
    }

    private void saveDiscount() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DISCOUNT_FILE))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Failed to save discount: " + e.getMessage());
        }
    }

    private void loadDiscount() {
        File file = new File(DISCOUNT_FILE);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                DiscountManager loaded = (DiscountManager) ois.readObject();
                this.discountPercentage = loaded.discountPercentage;
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to load discount. Using default 10%.");
                this.discountPercentage = 10;
            }
        } else {
            this.discountPercentage = 10;
        }
    }
}

