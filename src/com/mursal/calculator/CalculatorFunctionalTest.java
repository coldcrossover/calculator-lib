package com.mursal.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Functional tests that check com.mursal.calculator.Calculator passes work to a mocked service
public class CalculatorFunctionalTest {

    private CalculatorService calculatorService;
    private Calculator calculator;

    // Creates a fake service and gives it to the calculator before every test
    @BeforeEach
    public void setUp() {
        calculatorService = Mockito.mock(CalculatorService.class);
        calculator = new Calculator(calculatorService);
    }

    @Test
    public void testAddition() {
        Mockito.when(calculatorService.add(2.0, 3.0)).thenReturn(5.0);
        double result = calculator.add(2.0, 3.0);
        Assertions.assertEquals(5.0, result);
        Mockito.verify(calculatorService).add(2.0, 3.0);
    }

    @Test
    public void testSubtraction() {
        Mockito.when(calculatorService.subtract(5.0, 3.0)).thenReturn(2.0);
        double result = calculator.subtract(5.0, 3.0);
        Assertions.assertEquals(2.0, result);
        Mockito.verify(calculatorService).subtract(5.0, 3.0);
    }

    @Test
    public void testMultiplication() {
        Mockito.when(calculatorService.multiply(2.0, 3.0)).thenReturn(6.0);
        double result = calculator.multiply(2.0, 3.0);
        Assertions.assertEquals(6.0, result);
        Mockito.verify(calculatorService).multiply(2.0, 3.0);
    }

    @Test
    public void testDivision() {
        Mockito.when(calculatorService.divide(10.0, 2.0)).thenReturn(5.0);
        double result = calculator.divide(10.0, 2.0);
        Assertions.assertEquals(5.0, result);
        Mockito.verify(calculatorService).divide(10.0, 2.0);
    }

    @Test
    public void testDivisionByZero() {
        Mockito.when(calculatorService.divide(10.0, 0.0)).thenThrow(ArithmeticException.class);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    public void testModulus() {
        Mockito.when(calculatorService.modulus(10.0, 3.0)).thenReturn(1.0);
        double result = calculator.modulus(10.0, 3.0);
        Assertions.assertEquals(1.0, result);
        Mockito.verify(calculatorService).modulus(10.0, 3.0);
    }

    @Test
    public void testModulusByZero() {
        Mockito.when(calculatorService.modulus(10.0, 0.0)).thenThrow(ArithmeticException.class);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.modulus(10.0, 0.0));
    }

    @Test
    public void testExponential() {
        Mockito.when(calculatorService.exponential(2.0, 3.0)).thenReturn(8.0);
        double result = calculator.exponential(2.0, 3.0);
        Assertions.assertEquals(8.0, result);
        Mockito.verify(calculatorService).exponential(2.0, 3.0);
    }

    @Test
    public void testSquareRoot() {
        Mockito.when(calculatorService.squareRoot(16.0)).thenReturn(4.0);
        double result = calculator.squareRoot(16.0);
        Assertions.assertEquals(4.0, result);
        Mockito.verify(calculatorService).squareRoot(16.0);
    }

    @Test
    public void testSquareRootOfNegative() {
        Mockito.when(calculatorService.squareRoot(-9.0)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-9.0));
    }

    @Test
    public void testPercentage() {
        Mockito.when(calculatorService.percentage(20.0, 150.0)).thenReturn(30.0);
        double result = calculator.percentage(20.0, 150.0);
        Assertions.assertEquals(30.0, result);
        Mockito.verify(calculatorService).percentage(20.0, 150.0);
    }

    @Test
    public void testCalculatorDoesNotCallOtherMethods() {
        Mockito.when(calculatorService.add(1.0, 1.0)).thenReturn(2.0);
        calculator.add(1.0, 1.0);
        Mockito.verify(calculatorService).add(1.0, 1.0);
        Mockito.verifyNoMoreInteractions(calculatorService);
    }
}