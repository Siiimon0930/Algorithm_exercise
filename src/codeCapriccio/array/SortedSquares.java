package codeCapriccio.array;

/*
* 题意（leetcode977. 有序数组的平方）：给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 解题思路：双指针从首位往中间遍历 ，绝对值大的平方后尾插入新数组
*/
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] result = new int[nums.length];
        int i = 1;
        while (left <= right){
            if(Math.abs(nums[right]) >= Math.abs(nums[left])){
                // 右边绝对值比左边大时
                result[nums.length - i] = nums[right] * nums[right];
                right--;
            }else {
                // 左边绝对值大
                result[nums.length - i] = nums[left] * nums[left];
                left++;
            }
            i++;
        }
        return result;
    }
}
