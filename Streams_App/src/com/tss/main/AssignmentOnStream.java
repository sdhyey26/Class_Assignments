package com.tss.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AssignmentOnStream {
	public static void main(String[] args) {
        List<String> names = Arrays.asList("Jay", "Nimesh", "Mark", "Mahesh", "Ramesh");

        System.out.println(" First 3 names sorted ascending:");
        names.stream()
                .limit(3)
                .sorted()
                .forEach(System.out::println);

        System.out.println(" First 3 names with 'a', sorted ascending:");
        names.stream()
                .limit(3)
                .filter(name -> name.toLowerCase().contains("a"))
                .sorted()
                .forEach(System.out::println);

        System.out.println(" All names sorted descending:");
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println(" First 3 characters of each name:");
        names.stream()
                .map(name -> name.length() >= 3 ? name.substring(0, 3) : name)
                .forEach(System.out::println);

        System.out.println(" Names with <= 4 characters:");
        names.stream()
                .filter(name -> name.length() <= 4)
                .forEach(System.out::println);
	}
}
