package com.tss.abstractFactory.model;

public class MahindraFactory implements ICarFactory{

	@Override
	public Icars makeCar() {
		Icars mahindra = new Mahindra();
		return mahindra;
	}

}
