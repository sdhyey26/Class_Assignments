package com.tss.model.inhertitance.test;

import com.tss.model.inhertitance.model.Circle;
import com.tss.model.inhertitance.model.Square;
import com.tss.model.inhertitance.model.Shape;


public class ShapeTest {
	
	
	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape square = new Square();
		
		circle.area(10);
		square.area(5);
	}
}
