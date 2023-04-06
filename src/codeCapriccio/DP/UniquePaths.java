package codeCapriccio.DP;

import java.util.Arrays;

public class UniquePaths {
    /*
    * 题意（leetcode62. 不同路径）：见leetcode
    * 解题思路：
    */

    public int uniquePaths(int m, int n) {
        // 1.确定dp数组的含义，dp[i][j]表示到达（i, j）坐标的路径数
        int[][] dp = new int[m][n];
        // 2.确定递推公式：d[i][j] = d[i-1][j] + d[i][j-1]
        // 3.dp初始化，到达上边和左边的路径只有一条，就是一直往右，或者一直往下
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 4.确定遍历顺序，前往后
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
