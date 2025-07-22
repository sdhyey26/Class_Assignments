package com.tss.model.admin.menu;

import java.util.ArrayList;

import com.tss.exceptions.DuplicateItemException;
import com.tss.model.Menu.*;
import com.tss.model.admin.storage.FileStorage;

public class KoreanMenuManager {
	private static final String FILE = "KoreanMenuList.ser";
	public static ArrayList<KoreanMenu> list = FileStorage.loadListFromFile(FILE, KoreanMenu.class);


	public void addMenuItem(String name, double price, String description) {
		boolean found = false;

		for (KoreanMenu item : list) {
			if (name.equals(item.getFoodName())) {
				found = true;
			}
		}

		if (!found) {
			KoreanMenu menu = new KoreanMenu();
			menu.setFoodName(name);
			menu.setPrice(price);
			menu.setDescription(description);
			list.add(menu);
			FileStorage.saveListToFile(list, FILE);
			System.out.println("korean Menu updated successfully!");
		} else {
			throw new DuplicateItemException();
		}

	}

}
