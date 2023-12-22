package com.mastercode.google;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 15)));
//        System.out.println(solution(new int[]{}));
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 10, 2, 8}, 12)));
        System.out.println(Arrays.toString(solution(new int[]{4}, 4)));
        System.out.println(Arrays.toString(solution(new int[]{4}, 3)));
        System.out.println(Arrays.toString(solution(new int[]{4}, 5)));
    }

    public static int[] solution(int[] l, int t) {
        for (int start = 0; start < l.length; start++) {
            int sum = 0;
            for (int end = start; end < l.length; end++) {
                sum += l[end];
                if (sum == t) {
                    return new int[]{start, end};
                }
            }
        }
        return new int[]{-1, -1};
    }


}
