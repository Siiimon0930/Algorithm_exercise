package codeCapriccio.array;

/*
* 题意（leetcode704）. 二分查找：给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
* 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
* 解题思路：二分查找
*/
public class BiSearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
