package codeCapriccio.array;

/*
* 题意（leetcode27. 移除元素）：
* 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
* 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
* 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
* 解题思路：使用一个count变量记录遍历到当前位置时值为val的个数，后面的值往前移动count个位置
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val)
                count++;
            else
                nums[i - count] = nums[i];
        }
        return nums.length - count;
    }
}
