package codeCapriccio.DP;

public class Fib {
    /*
    * 题意（leetcode509. 斐波那契数）：
    *   斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。
    *   也就是：F(0) = 0，F(1)= 1
    *   F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    *   给定n ，请计算 F(n) 。
    * 解题思路：
    *   1.暴力递归法
    *   2.DP法
    */

    // 1.暴力递归法
    public int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return fib(n-1) + fib(n-2);
    }

    // 2.DP法
    public int fib2(int n){
        // 边界条件
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        // 1.确定dp数组以及下标的含义，dp[i]表示斐波那契数列第i个值
        int[] dp = new int[n+1];

        // 2.确定递推公式：dp[i] = dp[i-1] + dp[i-2]
        // 3.初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        // 4.确定遍历顺序，前->后
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 5.举列推到dp数组：按照这个递推公式dp[i] = dp[i - 1] + dp[i - 2]---0 1 1 2 3 5 8 13 21 34 55
        return dp[n];
    }
}
