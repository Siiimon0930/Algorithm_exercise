package codeCapriccio.DP;

public class CoinChange {
    /*
    * 题意（leetcode322. 零钱兑换）：
    *   给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    *   计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
    *   你可以认为每种硬币的数量是无限的。
    * 解题思路：
    *   完全背包问题，递推公式是dp[j] = min(dp[j],dp[j-coins[i]]+1）
    */
    public int coinChange(int[] coins, int amount) {
        // 1.dp数组的含义，dp[j]表示凑成金额j的最少硬币数量
        int[] dp = new int[amount+1];
        // 2.初始化dp[0]=1，其余初始化为MAX_VALUE
        for (int i = 0; i <= amount ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        // 3.递推公式dp[j] = min(dp[j],dp[j-coins[i]]
        // 4.遍历顺序，外层（硬币）内层（金额）都无所谓，各自的顺序都是递增
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
