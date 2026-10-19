package com.mursal.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Lab 3 unit tests, now running against the real service
public class CalculatorTest {

    private Calculator calculator;
    private static final double DELTA = 0.0001;

    // Builds a calculator with the real service before every test
    @BeforeEach
    public void setUp() {
        calculator = new Calculator(new CalculatorServiceImpl());
    }

    @Test
    public void testAddition() {
        Assertions.assertEquals(5.0, calculator.add(2.0, 3.0), DELTA);
    }

    @Test
    public void testSubtraction() {
        Assertions.assertEquals(2.0, calculator.subtract(5.0, 3.0), DELTA);
    }

    @Test
    public void testMultiplication() {
        Assertions.assertEquals(6.0, calculator.multiply(2.0, 3.0), DELTA);
    }

    @Test
    public void testDivision() {
        Assertions.assertEquals(5.0, calculator.divide(10.0, 2.0), DELTA);
    }

    @Test
    public void testDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    public void testModulus() {
        Assertions.assertEquals(1.0, calculator.modulus(10.0, 3.0), DELTA);
    }

    @Test
    public void testModulusNoRemainder() {
        Assertions.assertEquals(0.0, calculator.modulus(10.0, 5.0), DELTA);
    }

    @Test
    public void testModulusNegativeNumber() {
        Assertions.assertEquals(-1.0, calculator.modulus(-7.0, 3.0), DELTA);
    }

    @Test
    public void testModulusByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.modulus(10.0, 0.0));
    }

    @Test
    public void testExponential() {
        Assertions.assertEquals(8.0, calculator.exponential(2.0, 3.0), DELTA);
    }

    @Test
    public void testExponentialZeroPower() {
        Assertions.assertEquals(1.0, calculator.exponential(5.0, 0.0), DELTA);
    }

    @Test
    public void testExponentialNegativePower() {
        Assertions.assertEquals(0.5, calculator.exponential(2.0, -1.0), DELTA);
    }

    @Test
    public void testSquareRoot() {
        Assertions.assertEquals(4.0, calculator.squareRoot(16.0), DELTA);
    }

    @Test
    public void testSquareRootOfZero() {
        Assertions.assertEquals(0.0, calculator.squareRoot(0.0), DELTA);
    }

    @Test
    public void testSquareRootOfNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-9.0));
    }

    @Test
    public void testPercentage() {
        Assertions.assertEquals(30.0, calculator.percentage(20.0, 150.0), DELTA);
    }

    @Test
    public void testPercentageOfZero() {
        Assertions.assertEquals(0.0, calculator.percentage(50.0, 0.0), DELTA);
    }

    @Test
    public void testPercentageOverHundred() {
        Assertions.assertEquals(200.0, calculator.percentage(200.0, 100.0), DELTA);
    }
}