package com.mursal.calculator;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    @Override
    public double modulus(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot perform modulus by zero");
        }
        return num1 % num2;
    }

    @Override
    public double exponential(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number");
        }
        return Math.sqrt(num);
    }

    @Override
    public double percentage(double percent, double value) {
        return (percent / 100) * value;
    }
}