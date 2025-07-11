package com.tss.model.inhertitance.model;

public class Square extends Shape {
	private int length;
	
	void Square() {
		length = 40;
	}

	@Override
	public void area(int length) {
		// TODO Auto-generated method stub
		int area = length * length;
		System.out.println(area);
	}
}	
