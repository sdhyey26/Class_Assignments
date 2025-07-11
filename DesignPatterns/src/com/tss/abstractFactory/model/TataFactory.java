package com.tss.abstractFactory.model;

public class TataFactory implements ICarFactory{

	@Override
	public Icars makeCar() {
		// TODO Auto-generated method stub
		
		Icars tata = new Tata();
		
		return tata;
	}

}
