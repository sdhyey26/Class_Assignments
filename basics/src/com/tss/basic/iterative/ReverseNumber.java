package com.tss.basic.iterative;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int originalNumber = 12345;
        int reversedNumber = 0;

        while (originalNumber != 0) {
            int remainder = originalNumber % 10; 
            reversedNumber = reversedNumber * 10 + remainder;
            originalNumber = originalNumber / 10; 
        }

        System.out.println("Reversed number: " + reversedNumber); 
	}

}
