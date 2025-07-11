package com.tss.model.inhertitance.test;

import com.tss.model.inhertitance.model.Box;

public class BoxTest extends Box{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box(10 , 20 , 30);
		
		int density = 15;
		
		box.display();
		System.out.println("density : " + density);
	}

}
