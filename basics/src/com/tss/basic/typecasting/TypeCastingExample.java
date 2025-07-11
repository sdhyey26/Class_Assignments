package com.tss.basic.typecasting;

public class TypeCastingExample {
	public static void main(String[] args) {
		
		//impicit type conversion
		double var1 = 10;
		
		System.out.println(var1);
		
		//explicit type casting
		int var2 = (int) 10.5;
		
		byte a = 12;
		byte b = (byte) (a + 20);
		
		char var3 = 'a';
		
		int abc = 20;
		
		char number =(char)( abc + var3);
		System.out.println(number);
	}
}
