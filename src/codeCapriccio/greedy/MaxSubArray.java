package codeCapriccio.greedy;

public class MaxSubArray {
    /*
    * 题意（leetcode53. 最大子数组和）：
    *   给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    *   子数组 是数组中的一个连续部分。
    * 解题思路：
    *   1.暴力法，两层for循环
    *   2.贪心：
    *       局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
    *       全局最优：选取最大“连续和”
    *       注：大家在使用贪心算法求解本题，经常陷入的误区，就是分不清，是遇到 负数就选择起始位置，还是连续和为负选择起始位置。
    */

    // 1.暴力法（超时）
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for (int j = i; j < nums.length; j++) {
                tempSum += nums[j];
                if(tempSum > sum)
                    sum = tempSum;
            }

        }
        return sum;
    }

    // 1.贪心（时间复杂度：O（n），空间复杂度O（1））
    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if(curSum > maxSum)  // 当前sum大于maxSum时更新maxSum
                maxSum = curSum;
            if (curSum < 0)     // 当前sum<0时，将curSum赋值为0，从下个元素开始计算curSum
                curSum = 0;
        }
        return maxSum;
    }
}
