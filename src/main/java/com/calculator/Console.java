package com.calculator;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter an arithmetic expression like this: a + b");
        Scanner input = new Scanner(System.in);
        String delimeter = " ";
        String[] tokens = input.nextLine().split(delimeter);
        Calculator calculator = new Calculator();
        double result = 0.0;
        switch (tokens[1]) {
            case "+": result = calculator.getSum(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
            case "-": result = calculator.getDifference(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
            case "*": result = calculator.getProduct(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
            case "/": result = calculator.getQuotient(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
        }
        System.out.println("The expression result is " + result);

    }

}
