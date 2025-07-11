package com.tss.basic.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SubStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> stringArray = new ArrayList<String>();
		
		System.out.print("Enter the String : ");
		String word = sc.next();
		
		System.out.print("Enter the sub-string : ");
		String subWord = sc.next();
		
		for (int i = 0; i <= word.length() - subWord.length(); i++) {
            String window = word.substring(i, i + subWord.length());
            stringArray.add(window);
        }
		
		System.out.println(stringArray);
		
		if(stringArray.contains(subWord)) {
			System.out.print("The string contains the sub-string " + subWord);
		}
		else {
			System.out.print("The string does not contains the sub-string " + subWord);
		}
		//madam
		//01234
	}
}
