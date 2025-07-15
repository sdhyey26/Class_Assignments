package com.tss.main;

import java.util.*;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 7, 6);

        numbers.stream().forEach(number -> System.out.println(number));

        numbers.stream().forEach(number -> System.out.println(number * number));

        List<Integer> oddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);

        Set<Integer> squareNumbers = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toSet());

        System.out.println(squareNumbers);

        List<Integer> evenSquareNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .collect(Collectors.toList());

        System.out.println(evenSquareNumbers);
        
        int sum = numbers.stream().reduce(0, (number1, number2) -> number1 + number2);
        System.out.println(sum);

        System.out.println(numbers.stream().count());

        numbers.stream().limit(3).forEach(number -> System.out.print(number));

        System.out.println("Skip first 2:");
        numbers.stream()
               .skip(2)
               .forEach(num -> System.out.print(num + " "));
        System.out.println();

        boolean anyGreaterThan6 = numbers.stream()
                                         .anyMatch(num -> num > 6);
        System.out.println("Any number > 6? " + anyGreaterThan6);

        boolean allLessThan10 = numbers.stream()
                                       .allMatch(num -> num < 10);
        System.out.println("All numbers < 10? " + allLessThan10);

        System.out.println("Sorted list:");
        numbers.stream()
               .sorted()
               .forEach(num -> System.out.print(num + " "));
        System.out.println();

        Optional<Integer> max = numbers.stream()
                                       .max(Integer::compareTo);
        max.ifPresent(val -> System.out.println("Max value: " + val));

        Optional<Integer> min = numbers.stream()
                                       .min(Integer::compareTo);
        min.ifPresent(val -> System.out.println("Min value: " + val));
    }
}
