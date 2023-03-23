package codeCapriccio.greedy;

public class CanJump {
    /*
    * 题意（leetcode55. 跳跃游戏）：
    *   给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    *   数组中的每个元素代表你在该位置可以跳跃的最大长度。
    *   判断你是否能够到达最后一个下标。
    * 解题思路：
    *   局部最优：区间内选择的可到达下标最大的元素
    *   全局最优：如果每次区间可以往前移动则最终会全局最优可到达最后一个下标，若区间内每个元素到达最远处都是区间右值，则说明不可到达
    */

    public boolean canJump(int[] nums) {
        // 长度大于1且第一个步就不能跳，则直接返回false
        if(nums[0] == 0 && nums.length > 1)
            return false;
        // 长度为1 直接返回true
        else if(nums.length == 1)
            return true;
        for (int i = 0; i < nums.length;) {
            int tempMax = i + nums[i];
            int maxIndex = i;
            // 如果当前元素最远直达最后元素，则return ture
            if(tempMax >= nums.length - 1)
                return true;
            // 在当前区间找可到达最远的元素
            for (int j = i; j <= i + nums[i] ; j++) {
                int cur = j + nums[j];
                if(cur > tempMax){
                    tempMax = cur;
                    maxIndex = j;
                }
            }
            // 如果区间内最大的元素是左区间，则说明区间不可往前走了
            if(maxIndex == i)
                return false;
            else
                i = maxIndex;
        }
        return true;
    }

    // 简便版本
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
