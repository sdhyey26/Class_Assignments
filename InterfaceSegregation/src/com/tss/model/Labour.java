package com.tss.model;

import com.tss.Interface.Iworker;

public class Labour implements Iworker{

	@Override
	public void startWork() {
		// TODO Auto-generated method stub
        System.out.println("Labour starts working");

	}

	@Override
	public void stopWork() {
		// TODO Auto-generated method stub
        System.out.println("Labour stops working");

	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
        System.out.println("Labour is eating");

	}

	@Override
	public void drink() {
		// TODO Auto-generated method stub
        System.out.println("Labour is drinking");

	}

}
