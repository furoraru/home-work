package com.sbrf.reboot.calculator;

public class Calculator {

    public static int getAddition(int a, int b) {
        return a + b;
    }

    public static int getSubtraction(int a, int b) {
        return a - b;
    }

    public static int getMultiplication(int a, int b) {
        return a * b;
    }

    public static int getDivision(int a, int b) {
        return a / b;
    }

    public static int getSqr(int a) {
        return a * a;
    }

    public static int getDiscriminant(int a, int b, int c) {
        return getSqr(b) - 4 * a * c;
    }

    public static int getFactorial(int a) {
        if (a <= 2) {
            return a;
        }
        return a * getFactorial(a - 1);
    }

}
