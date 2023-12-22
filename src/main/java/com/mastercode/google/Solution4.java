package com.mastercode.google;

import java.math.BigInteger;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(solution("4", "7"));
        System.out.println(solution("2", "1"));
        System.out.println(solution("200", "200"));
    }

    public static String solution(String x, String y) {
        BombsCalculator bombsCalculator = new BombsCalculator(x, y);
        return bombsCalculator.calculateGenerations();
    }
}

class BombsCalculator {
    private static final String IMPOSSIBLE = "impossible";
    private BigInteger number1;
    private BigInteger number2;

    BombsCalculator(String x, String y) {
        this.number1 = new BigInteger(x);
        this.number2 = new BigInteger(y);
        rearrangeNumbers();
    }

    private void rearrangeNumbers() {
        BigInteger lowerNumber = number1.min(number2);
        BigInteger higherNumber = number1.max(number2);
        this.number1 = lowerNumber;
        this.number2 = higherNumber;
    }

    public String calculateGenerations() {
        BigInteger counter = BigInteger.ZERO;
        while (!number1.equals(BigInteger.ONE) && !number2.equals(BigInteger.ONE)) {
            if (isImpossible()) {
                return IMPOSSIBLE;
            }
            BigInteger[] coefficient = number2.divideAndRemainder(number1);
            counter = counter.add(coefficient[0]);
            number2 = number2.subtract(number1.multiply(coefficient[0]));
            rearrangeNumbers();
        }

        if (number1.equals(BigInteger.ONE) && number2.compareTo(BigInteger.ONE) > 0) {
            counter = counter.add(number2.subtract(BigInteger.ONE));
        }

        return counter.toString();
    }


    boolean isImpossible() {
        if (number1.equals(number2)) {
            return true;
        }

        return number1.compareTo(BigInteger.ONE) < 0 || number2.compareTo(BigInteger.ONE) < 0;
    }
}