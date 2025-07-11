package com.tss.basic.commandline;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[0]);
		
		add(a,b);
		sub(a,b);
		mul(a,b);
		div(a,b);

	}
	
	private static void add(int a , int b) {
		int sum = a+b;
		System.out.println("sum : " + sum);
	}
	
	private static void sub(int a , int b) {
		int sub = a-b;
		System.out.println("sub : " + sub);
	}
	
	private static void mul(int a , int b) {
		int mul = a*b;
		System.out.println("mul : " + mul);
	}
	
	private static void div(int a , int b) {
		int div = a/b;
		System.out.println("div : " + div);
	}

}
