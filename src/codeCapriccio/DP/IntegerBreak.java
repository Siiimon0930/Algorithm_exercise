package codeCapriccio.DP;

public class IntegerBreak {
    /*
    * 题意（leetcode343. 整数拆分）：
    *   给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 返回 你可以获得的最大乘积 。
    * 解题思路：
    */

    public int integerBreak(int n) {
        // 1.dp数组含义， dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n+1];
        // 2.递推公式，dp[i] = max(j * dp[i-j], j * (i-j), dp[i]) 其中j是变化的
        // 3.初始化，0，1不可拆不用初始化
        dp[2] = 1;
        // 4.遍历顺序，前至后
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j <= i-j; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }
}
