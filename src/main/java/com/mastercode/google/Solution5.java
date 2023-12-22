package com.mastercode.google;

public class Solution5 {
    public static void main(String[] args) {
//        System.out.println(solution(3))
        System.out.println(solution(8));
        System.out.println(solution(81));
        System.out.println(solution(200));
    }

    public static int solution(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int bricks = 2; bricks <= n; bricks++) {
            for (int height = 2; height <= n; height++) {
                dp[bricks][height] = dp[bricks - 1][height];

                if (height >= bricks) {
                    dp[bricks][height] += dp[bricks - 1][height - bricks];
                }
            }
        }

        return dp[n][n] - 1;
    }
}
