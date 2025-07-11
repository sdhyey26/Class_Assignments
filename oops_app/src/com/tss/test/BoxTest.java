package com.tss.test;

import com.tss.model.Box;

public class BoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box1 = new Box(0, 0, 0);
		
		box1.setDepth(40);
		box1.setHeight(45);
		box1.setWidth(20);
		
		System.out.println("The depth : " + box1.getDepth() );
		System.out.println("The Height : " + box1.getDepth() );		
		System.out.println("The Width : " + box1.getWidth());;
	}

}
