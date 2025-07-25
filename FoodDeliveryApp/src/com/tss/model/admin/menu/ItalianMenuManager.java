package com.tss.model.admin.menu;

import java.util.ArrayList;

import com.tss.exceptions.DuplicateItemException;
import com.tss.model.Menu.*;
import com.tss.model.admin.storage.FileStorage;

public class ItalianMenuManager {
	private static final String FILE = "ItalianMenuList.ser";
	public static ArrayList<ItalianMenu> list = FileStorage.loadListFromFile(FILE, ItalianMenu.class);

	public void addMenuItem(String name, double price, String description) {
		boolean found = false;

		for (ItalianMenu item : list) {
			if (name.equals(item.getFoodName())) {
				found = true;
			}
		}

		if (!found) {
			ItalianMenu menu = new ItalianMenu();
			menu.setFoodName(name);
			menu.setPrice(price);
			menu.setDescription(description);
			list.add(menu);
			FileStorage.saveListToFile(list, FILE);
			System.out.println("Italian Menu updated successfully!");
			
			for(ItalianMenu italainMenu : list) {
				System.out.println(italainMenu.toString());
			}
		} 
		else {
			throw new DuplicateItemException();
		}
	}
}
