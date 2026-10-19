# Calculator Library

A simple Java calculator library.

## Download
Get the JAR from the Releases page.

## Requirements
Java JDK 21

## Run it
java -jar calculator-lib-1.0.0.jar

## Use it in your project
Add the JAR as a library, then:

    import com.mursal.calculator.Calculator;
    import com.mursal.calculator.CalculatorServiceImpl;

    Calculator c = new Calculator(new CalculatorServiceImpl());
    System.out.println(c.add(2, 3));

## Operations
add, subtract, multiply, divide, modulus, exponential, squareRoot, percentage
