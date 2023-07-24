package codeCapriccio.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* leetcode15. 三数之和:
*   给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
*   同时还满足 nums[i] + nums[j] + nums[k] == 0 。
*   请你返回所有和为 0 且不重复的三元组。注意：答案中不可以包含重复的三元组。
* 解题思路：
*   1.排序后使用双指针法
*   2.对于nums[i], nums[j], nums[k]三个数都需要进行去重，要注意去重的细节
*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 0.数组排序
        Arrays.sort(nums);
        int left, right, sum;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                // 由于nums经过排序，所以如果当前元素>0则后续三数相加不可能为0了
                return result;
            }
            if(i > 0 && nums[i] == nums[i-1])
                // 去重第一个数，注意不能判断nums[i] == nums[i+1]来去重，因为这样去的是三元组内的重
                continue;
            left = i + 1;
            right = nums.length - 1;
            while(right > left){
                sum = nums[i] + nums[left] + nums[right];
                if(sum > 0)
                    right--;
                else if (sum < 0) {
                    left++;
                }else {
                    // sum等于0时先收获一个结果再去对left和right去重
                    List<Integer> item = new ArrayList<>();
                    item.addAll(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(item);
                    // 对left去重
                    while(right > left && nums[left] == nums[left+1])
                        left++;
                    // 对right去重
                    while(right > left && nums[right] == nums[right-1])
                        right--;
                    // TODO：这里要特别注意，取到结果后两个指针同时移动时必要步骤
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

}
