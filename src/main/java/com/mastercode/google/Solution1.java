package com.mastercode.google;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Write a function called solution(data, n) that takes in a list of less than 100 integers and a number n, and returns
 *  that same list but with all of the numbers that occur more than n times removed entirely. The returned list should
 * retain the same ordering as the original list - you don't want to mix up those carefully-planned shift rotations!
 *  For instance, if data was [5, 10, 15, 10, 7] and n was 1, solution(data, n) would return the list [5, 15, 7] because
 *  10 occurs twice, and thus was removed from the list entirely.
 *
 * public static int[] solution(int[] data, int n) {
 * }
 *
 * write optimal solution in java
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5}, 1))); // 1,4
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, 0)));//
    }

    public static int[] solution(int[] data, int n) {
        Map<Integer, Long> frequencyMap = Arrays.stream(data)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(data)
                .filter(num -> frequencyMap.get(num) <= n)
                .toArray();
    }
}
