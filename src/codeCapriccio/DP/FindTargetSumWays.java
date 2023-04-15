package codeCapriccio.DP;

public class FindTargetSumWays {
    /*
    * 题意（leetcode494. 目标和）：
    *   给你一个整数数组 nums 和一个整数 target 。
    *   向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
    *   例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
    *   返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
    * 解题思路：
    *   1.二维dp数组：
    *       dp[i][j]表示，在0-i物品间，取出和为j的取法数量。
    *       递推公式为：dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]],前者表示不取物品i的取法数量，后者表示取物品i的取法数量
    *   2.一维滚动数组dp：
    *       我们可以把数组中所有取正号的元素看作一个集合P，所有取负号的元素看作一个集合N。那么有：
    *       sum(P) - sum(N) = target
    *       sum(P) + sum(N) = sum(nums)
    *       两式相加得：sum(P) = (target + sum(nums)) / 2
    *       也就是说，我们只需要找到有多少种方法可以从数组中选出若干个元素使得它们的和等于(target + sum(nums)) / 2即可。
    *       这就变成了一个经典的01背包问题。
    *       所以我们可以把状态定义为dp【j】，表示用数组中若干个元素组成和为j的方案数。那么状态转移方程就是：
    *       dp【j】 = dp【j】 + dp[j - nums【i】]
    *       这个方程的意思是，如果我们要用若干个元素组成和为j的方案数，
    *       那么有两种选择：不选第i个元素或者选第i个元素。如果不选第i个元素，那么原来已经有多少种方案数就不变；
    *       如果选第i个元素，那么剩下要组成和为j - nums【i】 的方案数就等于dp[j - nums【i】]。所以两种选择相加就是dp【j】。
    */

    // 一维滚动dp
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }
        // 0.边界条件，如果target绝对值大于sum绝对值或者二者之和为奇数则无法做到，return0，
        if(Math.abs(target) > Math.abs(sum) || (target + sum) % 2 == 1)
            return 0;
        int size = (target + sum) / 2;
        // 1.dp数组的含义，dp[j]表示容量为j的背包装满的方法有几种（第i层）
        int[] dp = new int[size + 1];
        // 2.初始化dp[0]初始化为0
        dp[0] = 1;
        // 3.递推公式：dp[j] = dp[j](不选第i个元素) + dp[j-nums[i]]（选第i个元素），可简化为dp[j] += dp[j-nums[i]]
        // 4.遍历顺序 外层物品（0-i），内层容量（j-0）
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];


    }
}
