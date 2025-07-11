package com.tss.test;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Byfunction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		BiFunction<Integer , Integer , Integer> f = (a , b) ->
		{
			
			return a+b;
		};
		
		System.out.println(f.apply(sc.nextInt(), sc.nextInt()));
		
	}
}
