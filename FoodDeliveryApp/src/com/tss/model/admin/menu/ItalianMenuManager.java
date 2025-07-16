package com.tss.model.admin.menu;

import java.util.ArrayList;

import com.tss.model.Menu.*;
import com.tss.model.admin.storage.FileStorage;

public class ItalianMenuManager {
    private static final String FILE = "ItalianMenuList.ser";

    public void addMenuItem(String name, double price, String description) {
         ArrayList<ItalianMenu> list = FileStorage.loadListFromFile(FILE, ItalianMenu.class);

        ItalianMenu menu = new ItalianMenu();
        menu.setFoodName(name);
        menu.setPrice(price);
        menu.setDescription(description);
        list.add(menu);
        FileStorage.saveListToFile(list, FILE);
        System.out.println("Italian Menu updated successfully!");
    }
    
    
}
