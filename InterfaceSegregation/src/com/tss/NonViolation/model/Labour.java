package com.tss.NonViolation.model;

import com.tss.Interface.Iworker;
import com.tss.NonViolation.IFeedable;

public class Labour implements Iworker, IFeedable{

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
