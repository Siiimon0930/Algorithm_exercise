package codeCapriccio.DP;

public class LastStoneWeightII {
    /*
    * 题意（leetcode1049. 最后一块石头的重量 II）：见力扣
    * 解题思路：让所有石头尽可能分为两堆重量和一样的石头堆
    */
    // 滚动数组式dp
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i: stones){
            sum += i;
        }
        int target = sum / 2;
        // 1.dp数组含义，dp[j]表示第i层背包容量为j时可装的最大价值，其中石头价值==石头重量
        // 2.滚动数组初始化全为0就好
        // 3.状态转移方程：dp[j] = Math.max(dp[j]（上一层）, dp[j-stones[i]] + stones[i])
        int[] dp = new int[target+1];
        // 4.外层石头（上至下），内层背包容量（右至左）
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        // 最后返回值的话是把石头分为两堆重量和为dp[target]的石头，所有最后剩下的重量就说sum-2*dp[target]
        return sum - 2*dp[target];
    }
}
