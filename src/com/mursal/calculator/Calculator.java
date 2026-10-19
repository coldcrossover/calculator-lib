package com.mursal.calculator;

import java.util.Scanner;

/**
 * A simple calculator library.
 * <p>
 * Example: {@code new Calculator(new CalculatorServiceImpl()).add(2, 3);}
 */
public class Calculator {

    /** The service that does the real arithmetic. */
    private final CalculatorService calculatorService;

    /**
     * Creates a calculator that uses the given service.
     * The service is passed in so tests can supply a mock.
     *
     * @param calculatorService the service that performs the arithmetic
     */
    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * Adds two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the sum of num1 and num2
     */
    public double add(double num1, double num2) {
        return calculatorService.add(num1, num2);
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param num1 the number to subtract from
     * @param num2 the number to subtract
     * @return num1 minus num2
     */
    public double subtract(double num1, double num2) {
        return calculatorService.subtract(num1, num2);
    }

    /**
     * Multiplies two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the product of num1 and num2
     */
    public double multiply(double num1, double num2) {
        return calculatorService.multiply(num1, num2);
    }

    /**
     * Divides the first number by the second.
     *
     * @param num1 the dividend
     * @param num2 the divisor
     * @return num1 divided by num2
     * @throws ArithmeticException if num2 is zero
     */
    public double divide(double num1, double num2) {
        return calculatorService.divide(num1, num2);
    }

    /**
     * Returns the remainder of num1 divided by num2.
     *
     * @param num1 the dividend
     * @param num2 the divisor
     * @return the remainder
     * @throws ArithmeticException if num2 is zero
     */
    public double modulus(double num1, double num2) {
        return calculatorService.modulus(num1, num2);
    }

    /**
     * Raises a base to an exponent.
     *
     * @param base     the base number
     * @param exponent the power to raise the base to
     * @return base raised to the power of exponent
     */
    public double exponential(double base, double exponent) {
        return calculatorService.exponential(base, exponent);
    }

    /**
     * Returns the square root of a number.
     *
     * @param num the number (must not be negative)
     * @return the square root of num
     * @throws IllegalArgumentException if num is negative
     */
    public double squareRoot(double num) {
        return calculatorService.squareRoot(num);
    }

    /**
     * Returns a percentage of a value, for example 20% of 150 is 30.
     *
     * @param percent the percentage (20 means 20%)
     * @param value   the value to take the percentage of
     * @return the percentage of the value
     */
    public double percentage(double percent, double value) {
        return calculatorService.percentage(percent, value);
    }

    /**
     * Runs the command line calculator using the real service.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator(new CalculatorServiceImpl());

        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter operator (+, -, *, /, %, ^):");
        String operator = scanner.next();

        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();

        try {
            switch (operator) {
                case "+":
                    System.out.println("Result: " + calculator.add(num1, num2));
                    break;
                case "-":
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                    break;
                case "*":
                    System.out.println("Result: " + calculator.multiply(num1, num2));
                    break;
                case "/":
                    System.out.println("Result: " + calculator.divide(num1, num2));
                    break;
                case "%":
                    System.out.println("Result: " + calculator.modulus(num1, num2));
                    break;
                case "^":
                    System.out.println("Result: " + calculator.exponential(num1, num2));
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}