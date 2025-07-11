package com.tss.structural.facade.model;

public class ItalianHotel implements Ihotel{

	@Override
	public IMenu getMenu() {
		// TODO Auto-generated method stub
		return new ItalianMenu();
	}

}
