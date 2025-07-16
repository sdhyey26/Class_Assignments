package com.tss.model.admin;

import com.tss.model.admin.auth.AdminCredentialsManager;
import com.tss.model.admin.menu.*;
import com.tss.model.admin.agent.DeliveryAgentManager;
import com.tss.model.admin.discount.DiscountManager;
import com.tss.model.DeliveryAgents.*;

import java.util.ArrayList;

public class Admin {
    private final AdminCredentialsManager authManager = new AdminCredentialsManager();
    private final IndianMenuManager indianManager = new IndianMenuManager();
    private final KoreanMenuManager koreanManager = new KoreanMenuManager();
    private final ItalianMenuManager italianManager = new ItalianMenuManager();
    private final DeliveryAgentManager agentManager = new DeliveryAgentManager();
    private final DiscountManager discountManager = new DiscountManager();

    public String getName() {
        return authManager.getName();
    }

    public String getPassword() {
        return authManager.getPassword();
    }

    public void setName(String name) {
        authManager.setName(name);
    }

    public void setPassword(String password) {
        authManager.setPassword(password);
    }

    public void addIndianMenu(String name, double price, String description) {
        indianManager.addMenuItem(name, price, description);
    }

    public void addKoreanMenu(String name, double price, String description) {
        koreanManager.addMenuItem(name, price, description);
    }

    public void addItalianMenu(String name, double price, String description) {
        italianManager.addMenuItem(name, price, description);
    }

    public void addDeliveryAgents() {
        agentManager.addAgents();
    }

    public ArrayList<DeliveryAgent> getDeliveryAgents() {
        return agentManager.getAgents();
    }

    public void changeDiscountPercentage(int value) {
        discountManager.setDiscountPercentage(value);
    }

    public int getDiscountPercentage() {
        return discountManager.getDiscountPercentage();
    }
}
