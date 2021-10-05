package com.problem.coding.medium;

import java.util.Arrays;

/**
 * @author ankurmundra
 * October 01, 2021
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("a"));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        /*for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j)
                    dp[i][j] = 1;*/

        for (int i = n-1; i >=0 ; i--)
            for (int j = i; j < n; j++) {
                char a = s.charAt(i);
                char b = s.charAt(j);

                if (i == j)
                    dp[i][j] = 1;
                else if (j - i == 1 && a == b)
                    dp[i][j] = 2;
                else if (a == b && dp[i + 1][j - 1] != 0)
                    dp[i][j] = 2 + dp[i + 1][j - 1];
            }

        System.out.println(Arrays.deepToString(dp));
        int count = 0;

        for (int i = n-1; i >=0 ; i--)
            for (int j = i; j < n; j++)
                if (dp[i][j] != 0)
                    count++;
        return count;
    }
}
