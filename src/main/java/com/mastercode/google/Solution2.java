package com.mastercode.google;

import java.math.BigInteger;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 0, 2, 2, 0})); // 1,4
        System.out.println(solution(new int[]{-2, -3, 4, -5})); //
        System.out.println(solution(new int[]{0, 0, 0})); //
        System.out.println(solution(new int[]{-1})); //
        System.out.println(solution(new int[]{-1,-2,222})); //
        System.out.println(solution(new int[]{5, -7, 999, 1})); //

        int[] arr = new int[50];

        for (int i = 0; i < 50; i++) {
            arr[i] = 999;
        }
        System.out.println(solution(arr)); //
    }

    public static String solution(int[] xs) {
        int negativeCount = 0;
        int positiveCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        BigInteger product = BigInteger.ONE;

        for (int x : xs) {
            if (x == 0) {
                continue;
            }
            if (x < 0) {
                negativeCount++;
                if (maxNegative < x) {
                    maxNegative = x;
                }
            } else {
                positiveCount++;
            }
            product = product.multiply(BigInteger.valueOf(x));
        }

        if (positiveCount == 0 && negativeCount == 0) {
            return "0";
        }

        if (xs.length == 1 && negativeCount == 1) {
            return product.toString();
        }

        if (positiveCount == 0 && negativeCount == 1) {
            return "0";
        }

        if (negativeCount % 2 == 1) {
            return product.divide(BigInteger.valueOf(maxNegative)).toString();
        }

        return product.toString();
    }


}
