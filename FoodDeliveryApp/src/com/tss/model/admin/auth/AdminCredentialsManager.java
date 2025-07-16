package com.tss.model.admin.auth;

import java.io.*;

public class AdminCredentialsManager {
    private static final String FILE = "admin.ser";

    private String name = "admin";
    private String password = "admin";

    public AdminCredentialsManager() {
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
            oos.writeObject(new AdminCredentials(name, password));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCredentials() {
        File file = new File(FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                AdminCredentials creds = (AdminCredentials) ois.readObject();
                this.name = creds.name;
                this.password = creds.password;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static class AdminCredentials implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        String password;

        public AdminCredentials(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }
}
