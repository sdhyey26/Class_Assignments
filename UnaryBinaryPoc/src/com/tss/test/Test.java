package com.tss.test;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {

        UnaryOperator<Integer> square = (n) ->{
        	return n * n;
        };

        BinaryOperator<Integer> add = (a, b) -> {
        	return a + b;
        };

        int value = 5;
        int a = 10, b = 15;

        int squaredResult = square.apply(value);
        int sumResult = add.apply(a, b);

        System.out.println("Square of " + value + " is: " + squaredResult);
        System.out.println("Sum of " + a + " and " + b + " is: " + sumResult);
    }
}
