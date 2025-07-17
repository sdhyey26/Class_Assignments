package com.tss.model.admin.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.tss.model.admin.auth.CustomerCredentialManager.CustomerCredential;

public class CustomerCredentialManager {
    private static final String FILE = "customer.ser";

    private String name ;
    private String password ;

    public CustomerCredentialManager() {
        loadCredentials();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
        saveCredentials();
    }

    public void setPassword(String password) {
        this.password = password;
        saveCredentials();
    }

    private void saveCredentials() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(new CustomerCredential(name, password));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCredentials() {
        File file = new File(FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            	CustomerCredential creds = (CustomerCredential) ois.readObject();
                this.name = creds.name;
                this.password = creds.password;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static class CustomerCredential implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        String password;

        public CustomerCredential(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

}
