package com.tss.structural.Adapter.model;

public class HatAdapter implements Iitems{

	Hat current = new Hat();
	
	public HatAdapter(Hat hat ) {
		current = hat;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return  current.getLongName() + " " + current.getShortName();
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return current.getPrice();
	}

}
