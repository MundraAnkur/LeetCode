package com.problem.coding.medium;

/**
 * @author ankurmundra
 * October 01, 2021
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                int d = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;

                if (i == n - 1 && j == m - 1)
                    dp[i][j] = 1 - dungeon[i][j];
                else {
                    if (i != n - 1)
                        d = dp[i + 1][j] - dungeon[i][j];
                    if (j != m - 1)
                        r = dp[i][j + 1] - dungeon[i][j];
                    dp[i][j] = Math.min(d, r);
                    if (dp[i][j] <= 0) dp[i][j] = 1;
                }
            }
        return dp[0][0];
    }
}
