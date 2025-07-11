package com.tss.structural.facade.model;

import java.util.Scanner;

public class IndianHotel implements Ihotel {

	@Override
	public IMenu getMenu() {
		// TODO Auto-generated method stub
			
			return new IndianMenu();
		
	}

}
