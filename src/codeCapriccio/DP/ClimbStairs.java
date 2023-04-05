package codeCapriccio.DP;

public class ClimbStairs {
    /*
    * 题意（leetcode70. 爬楼梯）：
    *   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    * 解题思路：
    *   1.递归法（超时）
    *   2.DP
    */

    // 1.递归法
    public int climbStairs0(int n) {
        if (n <= 2)
            return n;
        return climbStairs0(n-1) + climbStairs0(n-2);
    }

    // 2.DP法
    public int climbStairs(int n){
        // 0边界条件
        if(n <= 2)
            return n;
        // 1.确定dp数组， dp[i]表示i层阶梯的方式
        int[] dp = new int[n];
        // 2.确定递推公式，dp[i] = d[i-1] + d[i-2]
        // 3.初始化dp数组
        dp[0] = 1;
        dp[1] = 2;
        // 确定遍历顺数，前至后
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
