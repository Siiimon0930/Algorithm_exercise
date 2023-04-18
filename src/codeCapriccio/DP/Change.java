package codeCapriccio.DP;

public class Change {
    /*
    * 题意（leetcode518. 零钱兑换 II）：
    *   给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
    *   请你计算并返回可以凑成总金额的硬币 TODO:组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
    *   假设每一种面额的硬币有无限个。
    *   题目数据保证结果符合 32 位带符号整数。
    * 解题思路：完全背包问题
    */

    public int change(int amount, int[] coins) {
        // 1.dp数组的含义，dp[j]表示第i层物品，组成面额为j的方案数
        int[] dp = new int[amount + 1];
        // 2.初始化，首先dp[0]一定要为1，dp[0] = 1是 递归公式的基础。如果dp[0] = 0 的话，后面所有推导出来的值都是0了。
        // dp[0]=1还说明了一种情况：如果正好选了coins[i]后，也就是j-coins[i] == 0的情况表示这个硬币刚好能选，此时dp[0]为1表示只选coins[i]存在这样的一种选法。
        dp[0] = 1;
        // 3.递推公式dp[j] = dp[j](0~i-1时的方案数) + dp[j-coins[i]]
        // 4.遍历顺序，外层（硬币0~i），内存（面额0~j）
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        for (int i:
             dp) {
            System.out.println(i);
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        // 1.dp数组的含义，dp[i][j]表示 0~i范围，组成j面额的组合数
        int[][] dp = new int[coins.length][amount + 1];
        // 2.初始化，第一列初始化为1，第一行能整除coins[0]的设为1
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = coins[0]; i <= amount; i++) {
            if(i % coins[0] == 0)
                dp[0][i] = 1;
        }
        // 3.递推公式dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
        // 4.遍历顺序，外层（硬币0~i），内存（面额0~j）
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount ; j++) {
                if(j < coins[i])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
            }
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount ; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[coins.length-1][amount];
    }
}
