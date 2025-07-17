package com.tss.model.admin.menu;

import com.tss.exceptions.DuplicateItemException;
import com.tss.model.Menu.*;
import com.tss.model.admin.storage.FileStorage;

import java.util.ArrayList;

public class IndianMenuManager {
    private static final String FILE = "IndianMenuList.ser";

    public void addMenuItem(String name, double price, String description) {
        ArrayList<IndianMenu> list = FileStorage.loadListFromFile(FILE, IndianMenu.class);
        
        if(!list.contains(name)) {
        	IndianMenu menu = new IndianMenu();
            menu.setFoodName(name);
            menu.setPrice(price);
            menu.setDescription(description);
            list.add(menu);
            FileStorage.saveListToFile(list, FILE);
            System.out.println("Indian Menu updated successfully!");
        }
        else {
        	throw new DuplicateItemException();
        }
        
    }
    
   
}
