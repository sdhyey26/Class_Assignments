package com.tss.Nonviolation.model;

import com.tss.Nonviolation.Interface.Iunflyable;

public class Ostrich implements Iunflyable {

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		System.out.println("brown");
	}

	@Override
	public void cannotFly() {
		// TODO Auto-generated method stub
		System.out.println("Ostrich Cannot fly");
	}

}
