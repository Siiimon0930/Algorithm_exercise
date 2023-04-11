package codeCapriccio.DP;

public class NumTrees {
    /*
    * 题意（leetcode96. 不同的二叉搜索树）：
    *   给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
    * 解题思路：
    *   dp[i]表示整数i满足的BST的种树，而i时，分为左右两部分
    */
    public int numTrees(int n){
        // 1.dp[i]表示整数i满足的BST的种树
        int[] dp = new int[n+1];
        // 2.递推方程：dp[i] += dp[j-1] * dp[i-j] , j 从1到i
        // 3.dp[0]、dp[1]初始化为1
        dp[0] = 1;
        dp[1] = 1;
        // 4.递归方向：前至后
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
