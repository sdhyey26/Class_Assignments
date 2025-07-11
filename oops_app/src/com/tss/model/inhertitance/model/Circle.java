package com.tss.model.inhertitance.model;

public class Circle extends Shape {

	private float radius;
	
	void Circle() {
		radius = 10;
	}
	
	@Override
	public void area(int radius) {
		// TODO Auto-generated method stub
		float area =  (float) (3.14 * radius * radius);
		System.out.println(area);
	}

}
