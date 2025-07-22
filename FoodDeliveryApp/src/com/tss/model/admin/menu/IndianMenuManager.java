package com.tss.model.admin.menu;

import com.tss.exceptions.DuplicateItemException;
import com.tss.model.Menu.*;
import com.tss.model.admin.storage.FileStorage;

import java.util.ArrayList;

public class IndianMenuManager {
    private static final String FILE = "IndianMenuList.ser";
    public static ArrayList<IndianMenu> list = FileStorage.loadListFromFile(FILE, IndianMenu.class);
    
    public void addMenuItem(String name, double price, String description) {
        boolean found = false;
        
        for(IndianMenu item : list) {
        	if(name.equals(item.getFoodName())) {
        		found = true;
        	}
        }
        
        if(!found) {
        	IndianMenu menu = new IndianMenu();
            menu.setFoodName(name);
            menu.setPrice(price);
            menu.setDescription(description);
            list.add(menu);
            FileStorage.saveListToFile(list, FILE);
            System.out.println("Indian Menu updated successfully!");
            
            for(IndianMenu indianMenu : list) {
            	System.out.println(indianMenu.toString());
            }
        }
        else {
        	throw new DuplicateItemException();
        }
        
    }
    
   
}
