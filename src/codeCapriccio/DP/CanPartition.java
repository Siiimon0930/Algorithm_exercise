package codeCapriccio.DP;

public class CanPartition {
    /*
    * 题意（leetcode416. 分割等和子集）：
    *   给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    * 解题思路：
    *   可等效为一个01背包问题，背包容量为nums数组和的一半, nums即是value数组，也是weight数组，即value[i]=weight[i]，
    *   最后看最大价值是不是等于容量，是则true，否则false
    */
    // 1.二维dp数组
    public boolean canPartition(int[] nums){
        // 0.背包容量为nums和的一半
        int bagWeight = 0;
        for (int i:
             nums) {
            bagWeight += i;
        }
        if(bagWeight % 2 == 1)  // 如果和是奇数，则直接返回false，因为nums中元素都是正整数
            return false;
        bagWeight = bagWeight / 2;
        // 1.dp数组的含义，dp[i][j]表示0-i个元素，背包容量为j时背包的最大价值
        int[][] dp = new int[nums.length][bagWeight+1];
        // 2.dp数组初始化, 第一列（容量为0）为0，第一行j>weight[0]处初始化为value[0]
        for (int i = nums[0]; i <= bagWeight ; i++) {
            dp[0][i] = nums[0];
        }
        // 3.状态转移方程为：dp[i][j] = max（dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]）
        // 4.遍历顺序：外层物品（上至下），内层背包容量（左至右）
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if(j < nums[i])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
            }
        }
        if(dp[nums.length-1][bagWeight] == bagWeight)
            return true;
        else
            return false;
    }

    // 2.滚动dp数组
    public boolean canPartition2(int[] nums){
        // 0.背包容量为nums和的一半
        int bagWeight = 0;
        for (int i:
                nums) {
            bagWeight += i;
        }
        if(bagWeight % 2 == 1)  // 如果和是奇数，则直接返回false，因为nums中元素都是正整数
            return false;
        bagWeight = bagWeight / 2;
        // 1.dp数组含义，dp[j]表示容量为j时，最大价值，这个价值要取决于遍历到第几个物品
        int[] dp = new int[bagWeight+1];
        // 2.初始化dp，实际上不用初始化，都全为0就好
        // 3.状态转移方程：dp[j] = max（dp[j]（这个是上一层的）, dp[j-nums[i]]+nums[i]）
        // 4.遍历顺序，外层还是物品（上至下），内层背包容量（右至左）
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagWeight; j > 0 ; j--) {
                // 如果j<nums[i],表示当前容量装不下物品i，则应物品i-1时容量j的dp值，所以不用动
                if(j >= nums[i])
                    dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        if (dp[bagWeight] == bagWeight)
            return true;
        return false;
    }
}
