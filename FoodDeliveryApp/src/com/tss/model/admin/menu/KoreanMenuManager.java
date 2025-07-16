package com.tss.model.admin.menu;

import java.util.ArrayList;

import com.tss.model.Menu.*;
import com.tss.model.admin.storage.FileStorage;

public class KoreanMenuManager {
    private static final String FILE = "KoreanMenuList.ser";

    public void addMenuItem(String name, double price, String description) {
        ArrayList<KoreanMenu> list = FileStorage.loadListFromFile(FILE, KoreanMenu.class);
        KoreanMenu menu = new KoreanMenu();
        menu.setFoodName(name);
        menu.setPrice(price);
        menu.setDescription(description);
        list.add(menu);
        FileStorage.saveListToFile(list, FILE);
        System.out.println("korean Menu updated successfully!");
    }
    
    
}
