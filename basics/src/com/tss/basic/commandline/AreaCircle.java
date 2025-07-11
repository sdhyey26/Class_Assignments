package com.tss.basic.commandline;

import java.util.Scanner;

public class AreaCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float radius = Integer.parseInt(args[0]);
		
		double area = 3.14*radius*radius;
		
		System.out.print("area : " + area);
	}

}