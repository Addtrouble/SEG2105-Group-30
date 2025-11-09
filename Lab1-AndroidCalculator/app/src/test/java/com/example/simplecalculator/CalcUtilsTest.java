package com.example.simplecalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcUtilsTest {
    @Test
    public void calculate_addition() {
        assertEquals(7.0, CalcUtils.calculate(3.0, 4.0, "+"), 1e-9);
    }
    @Test
    public void calculate_subtraction() {
        assertEquals(-1.0, CalcUtils.calculate(3.0, 4.0, "-"), 1e-9);
    }
    @Test
    public void calculate_multiplication() {
        assertEquals(12.0, CalcUtils.calculate(3.0, 4.0, "*"), 1e-9);
    }
    @Test
    public void calculate_division() {
        assertEquals(2.0, CalcUtils.calculate(8.0, 4.0, "/"), 1e-9);
    }
    @Test
    public void calculate_divideByZero_returnsNaN() {
        assertTrue(Double.isNaN(CalcUtils.calculate(5.0, 0.0, "/")));
    }
    @Test
    public void trim_wholeNumber_removesDecimal() {
        assertEquals("42", CalcUtils.trimDouble(42.0));
    }
    @Test
    public void trim_fractional_keepsDecimal() {
        assertEquals("3.5", CalcUtils.trimDouble(3.5));
    }

    //Temporary fail demos for the video
    @Test
    public void calculate_addition_FAIL_demo() {
        // Wrong on purpose correct is 7.0
        assertEquals(8.0, CalcUtils.calculate(3.0, 4.0, "+"), 1e-9);
    }
    @Test
    public void trim_wholeNumber_FAIL_demo() {
        // Wrong on purpose correct is "42"
        assertEquals("42.0", CalcUtils.trimDouble(42.0));
    }
}
