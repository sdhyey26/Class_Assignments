package com.tss.Nonviolation.model;

import com.tss.Nonviolation.Interface.Iflyable;

public class pigeon implements Iflyable{

	@Override
	public void canFly() {
		// TODO Auto-generated method stub
		System.out.println("pigeon can fly");
	}

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		System.out.println("grey");
	}

}
