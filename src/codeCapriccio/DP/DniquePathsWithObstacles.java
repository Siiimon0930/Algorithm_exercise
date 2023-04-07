package codeCapriccio.DP;

public class DniquePathsWithObstacles {
    /*
    * 题意（leetcode63. 不同路径 II）：见leetcode
    * 解题思路：
    *   到达障碍物的路径为0
    */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 0.边界条件判断，如果起始位置就是障碍物则无法到达
        if(obstacleGrid[0][0] == 1)
            return 0;
        // 1.dp数组的含义，dp[i][j]还是表示到达（i,j）的路径数
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 2.递推公式还是dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // 3.初始化第一行和第一列为1，若碰到障碍物，则障碍物以及其后的都为0
        // 初始化第一行
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 初始化第一列
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 4.确定遍历顺序，前至后
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
