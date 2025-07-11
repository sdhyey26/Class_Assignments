package com.tss.test;

import java.util.Scanner;

import com.tss.model.IPattern;

public class PatternTest {
	public static void main(String[] args) {
		
		
		IPattern ipattern = () -> {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the rows : ");
			int rows = sc.nextInt();
			int z = 1;
			for(int i = 0 ; i < rows ; i++) {
				for(int j = 0 ; j < i ; j++) {
					System.out.print(z++ + " ");
				}
				System.out.println();
			}
		};
		
		ipattern.printPattern();
	}
}
