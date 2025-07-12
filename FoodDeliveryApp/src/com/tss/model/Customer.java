package com.tss.model;

import java.util.ArrayList;

public class Customer {
	
	private String name ;
	private String password ;
	private String address ;
	
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
	
	public ArrayList<Menu> makeOrders(String name){
		
		Menu menu = new Menu();
		
		ArrayList<Menu> menuList = menu.getMenu();
		
		ArrayList<Menu> orderList = new ArrayList<>();
		
		for(Menu item : menuList) {
			if(item.equals(name)) {
				String foodName = item.getFoodName();
				String description = item.getDescription();
				double foodPrice = item.getPrice();
				
				menu.setDescription(description);
				menu.setFoodName(foodName);
				menu.setPrice(foodPrice);
				
				orderList.add(menu);
			}
		}
		
		
		return orderList;
	}
}
