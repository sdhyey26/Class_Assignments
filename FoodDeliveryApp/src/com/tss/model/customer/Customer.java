package com.tss.model.customer;

import java.io.*;
import java.util.ArrayList;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String password;
    private String address;
    private static final String FILE_NAME = "customer.ser";

    private ArrayList<Customer> customerList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Customer> getCustomer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            customerList = (ArrayList<Customer>) ois.readObject();
        } catch (FileNotFoundException e) {
            customerList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public void setCustomer(Customer customer) {
        ArrayList<Customer> list = getCustomer(); 
        list.add(customer);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
