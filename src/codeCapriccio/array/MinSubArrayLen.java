package codeCapriccio.array;

/*
* 题意（leetcode209. 长度最小的子数组）：
* 给定一个含有n个正整数的数组和一个正整数 target 。
* 找出该数组中满足其和 ≥ target 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]，并返回其长度。如不存在符合条件的子数组返回0
* 解题思路：两个前后指针，分别指向子数组的左右区间；在整体往右遍历的过程中求最小子数组长度
*/
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0; // 区间内的和
        int subLength = 0; // 滑动区间的长度
        int i = 0; // 区间的左下标
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= target){ // 当前区间和>=target时开始缩小区间
                subLength = j - i + 1;
                result = subLength < result ? subLength : result;
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
