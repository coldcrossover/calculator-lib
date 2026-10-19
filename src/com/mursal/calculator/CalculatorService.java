package com.mursal.calculator;

public interface CalculatorService {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
    double modulus(double num1, double num2);
    double exponential(double base, double exponent);
    double squareRoot(double num);
    double percentage(double percent, double value);
}