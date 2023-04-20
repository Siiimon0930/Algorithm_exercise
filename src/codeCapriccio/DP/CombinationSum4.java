package codeCapriccio.DP;

public class CombinationSum4 {
    /*
    * 题意（leetcode377. 组合总和 Ⅳ）：
    *   给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
    *   题目数据保证答案符合 32 位整数范围。
    * 解题思路：完全背包，排列问题，遍历顺序，内层物品 外层背包
    */
    public int combinationSum4(int[] nums, int target) {
        // 0.判断边界条件，如果target小于nums中的最小值则return 0
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= target){
                flag = false;
                break;
            }
        }
        if(flag)
            return 0;
        // 1.dp数组的含义，dp[j]表示 0-i物品范围内，构成总和为j的排列数量
        int[] dp = new int[target + 1];
        // 2.初始化为dp[0]初始化为1
        dp[0] = 1;
        // 3.递推公式：dp[j] = dp[j] + dp[j-nums[i]]
        // 4.遍历顺序：外层是容量，内层是物品
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] <= i)
                    dp[i] += dp[i-nums[j]];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[target];
    }

}
