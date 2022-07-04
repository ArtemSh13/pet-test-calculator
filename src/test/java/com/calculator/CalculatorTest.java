package com.calculator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CalculatorTest {
    private final double firstNumber;
    private final double secondNumber;

    private final double delta = 0.0000000001;

    public CalculatorTest(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getCalculatingData() {
        return new Object[][]{
                {903, 301},
                {482, -699},
                {919, 520.985},
                {873, -215.224},
                {947, 0.346},
                {430, -0.496},
                {-224, -260},
                {-476, 978.87},
                {-867, -129.445},
                {-503, 0.02},
                {-123, -0.522},
                {-775, 5},
                {397.013, 224.74},
                {671.909, -447.583},
                {786.673, 0.113},
                {364.128, -0.188},
                {478.092, 99},
                {370.178, -826},
                {-185.708, -73.465},
                {-500.06, 0.331},
                {-320.304, -0.323},
                {-924.482, 189},
                {-747.965, -922},
                {-703.801, 703.801},
                {0.777, 0.111},
                {0.754, -0.8},
                {0.213, 205},
                {0.983, -664},
                {0.448, 261.694},
                {0.417, -102.388},
                {-0.003, -0.069},
                {-0.383, 471},
                {-0.507, -93},
                {-0.77, 913.257},
                {-0.591, -435.522},
                {-0.504, 0.204},
                {0, 221},
                {0, -24},
                {0, 144.353},
                {0, -485.319},
                {0, 0.756},
                {0, -0.246}
        };
    }

    @Test
    public void getSumOf2DoubleReturnDouble() {
        Calculator calculator = new Calculator();
        double expected = firstNumber + secondNumber;
        Assert.assertEquals("Sum (+) is incorrect", expected, calculator.getSum(firstNumber, secondNumber), delta);
    }

    @Test
    public void getDifferenceOf2DoubleReturnDouble() {
        Calculator calculator = new Calculator();
        double expected = firstNumber - secondNumber;
        Assert.assertEquals("Difference (-) is incorrect", expected, calculator.getDifference(firstNumber, secondNumber), delta);
    }

    @Test
    public void getProductOf2DoubleReturnDouble() {
        Calculator calculator = new Calculator();
        double expected = firstNumber * secondNumber;
        Assert.assertEquals("Product (*) is incorrect", expected, calculator.getProduct(firstNumber, secondNumber), delta);
    }

    @Test
    public void getQuotientOf2DoubleReturnDouble() throws Exception {
        Calculator calculator = new Calculator();
        double expected = firstNumber / secondNumber;
        Assert.assertEquals("Quotient (/) is incorrect", expected, calculator.getQuotient(firstNumber, secondNumber), delta);
    }

    @Test
    public void getExceptionViaDivisionByZero() {
        Calculator calculator = new Calculator();
        Exception thrown = Assert.assertThrows(Exception.class, () -> calculator.getQuotient(firstNumber, 0));
        Assert.assertEquals("Invalid exception message", "Error: division by zero", thrown.getMessage());
    }
}
