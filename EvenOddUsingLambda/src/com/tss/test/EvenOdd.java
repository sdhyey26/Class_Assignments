package com.tss.test;

import java.util.Scanner;
import java.util.function.Predicate;

public class EvenOdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Predicate<Integer> bi = (a )->{
			if(a % 2 == 0 ) {
				return true;
			}
			else {
				return false;
			}
		};
		
		if(bi.test(sc.nextInt())) {
			System.out.println("the number is even");
		}
		else {
			System.out.println("the numeber is odd");
		}
	}
}
