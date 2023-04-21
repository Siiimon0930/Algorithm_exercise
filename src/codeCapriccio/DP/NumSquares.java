package codeCapriccio.DP;

public class NumSquares {
    /*
    * 题意（leetcode279. 完全平方数）：
    *   给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
    *   完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和16都是完全平方数，而 3 和 11 不是。
    * 解题思路：
    *   物品数量从0-i，其中i最大值为根号n向下取整，dp[j] = min(dp[j], dp[j-i*i]+1)
    */
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
