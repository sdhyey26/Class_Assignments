package com.tss.basic.Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class StringShifter {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String str = Sc.next();
        String newStr = "";

        System.err.print("Enter the number of digits that needed to be shifted : ");
        int n = Sc.nextInt();

        for(int i = 0 ; i < str.length() ; i++){
            newStr += (char) ((str.charAt(i) - 'a' + n) % 26 + 'a');
            System.out.print(newStr.charAt(i));
        }
    }
}
