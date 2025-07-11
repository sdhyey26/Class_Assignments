package com.tss.structural.facade.model;

public class HotelReception {
	
	public void getIndianMenu() {
		Ihotel indianHotel = new IndianHotel();
		IMenu menu = indianHotel.getMenu();
		menu.displayMenu();
	}
	
	public void getItalianMenu() {
		Ihotel italianMenu = new ItalianHotel();
		IMenu menu = italianMenu.getMenu();
		menu.displayMenu();
	}
}
