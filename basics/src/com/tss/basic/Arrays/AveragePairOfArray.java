package com.tss.basic.Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class AveragePairOfArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();
        int[] array = new int[size];
        int sum = 0;

        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        int average = sum / size;
        System.out.println("Average: " + average);

        HashSet<Integer> seen = new HashSet<>();
        boolean isFound = false;

        for (int i = 0; i < size; i++) {
            int complement = average - array[i];
            if (seen.contains(complement)) {
                System.out.println("Yes, there exists a pair: " + array[i] + ", " + complement);
                isFound = true; 
            }
            seen.add(array[i]);
        }

        if (!isFound) {
            System.out.println("No pair found");
        }
}
}
