package com.calculator;

public class Calculator {
    double getSum(double a, double b) {
        return a + b;
    }

    double getDifference(double a, double b) {
        return a - b;
    }

    double getProduct(double a, double b) {
        return a * b;
    }

    double getQuotient(double a, double b) throws Exception {
        if (b == 0) {
            throw  new ArithmeticException("Error: division by zero");
        }
        return a / b;
    }
}
