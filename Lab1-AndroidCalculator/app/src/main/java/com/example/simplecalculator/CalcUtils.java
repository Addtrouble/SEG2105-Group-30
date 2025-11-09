package com.example.simplecalculator;

public final class CalcUtils {
    private CalcUtils() {}

    public static double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? Double.NaN : a / b;
            default:  return 0;
        }
    }
    public static String trim(double x) {
        long lx = (long) x;
        return (x == lx) ? Long.toString(lx) : Double.toString(x);
        //same behavior as MainActivity.trim()
    }
    public static String trimDouble(double x) {
        long lx = (long) x;
        return (x == (double) lx) ? Long.toString(lx) : Double.toString(x);
    }

}
