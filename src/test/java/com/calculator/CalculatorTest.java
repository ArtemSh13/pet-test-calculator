package com.calculator;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {
    @Test
    public void getSumOf2DoubleReturnDouble(double a, double b) {
        Calculator calculator = new Calculator();
        double expected = a + b;
        Assert.assertEquals("Sum (+) is incorrect", expected, calculator.getSum(a, b));
    }

    @Test
    public void getDifferenceOf2DoubleReturnDouble(double a, double b) {
        Calculator calculator = new Calculator();
        double expected = a - b;
        Assert.assertEquals("Difference (-) is incorrect", expected, calculator.getDifference(a, b));
    }

    @Test
    public void getProductOf2DoubleReturnDouble(double a, double b) {
        Calculator calculator = new Calculator();
        double expected = a * b;
        Assert.assertEquals("Product (*) is incorrect", expected, calculator.getProduct(a, b));
    }

    @Test
    public void getQuotientOf2DoubleReturnDouble(double a, double b) {
        Calculator calculator = new Calculator();
        double expected = a / b;
        Assert.assertEquals("Quotient (/) is incorrect", expected, calculator.getQuotient(a, b));
    }

    @Test
    public void getExceptionViaDivisionByZero(double a) {
        Calculator calculator = new Calculator();
        Exception thrown = Assert.assertThrows(Exception.class, () -> calculator.getQuotient(a, 0));
        Assert.assertEquals("Invalid exception message", "Error: division by zero", thrown.getMessage());
    }
}
