package com.tss.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator; 

    @BeforeEach
    void init() {
        calculator = new Calculator(); 
    }

    @Test
    void testSum() {
        int actualResult = calculator.sum(3, 2);
        assertEquals(5, actualResult);
    }

    @Test
    void testSubstraction() {
        int substraction = calculator.substract(5, 2);
        assertEquals(3, substraction);
    }

    @Test
    void testDivision() {
        int divisionResult = calculator.division(10, 0);
        assertEquals(5, divisionResult);
    }

    @Test
    void testMultiplication() {
        int multiplication = calculator.multiplication(2, 5);
        assertEquals(10, multiplication);
    }

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.division(10, 0);
        });
    }
}
