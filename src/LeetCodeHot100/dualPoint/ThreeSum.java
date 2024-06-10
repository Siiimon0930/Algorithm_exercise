package LeetCodeHot100.dualPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15.三数之和
 * @Author: Siiimon
 * @Date: 2024/06/10/19:17
 */
public class ThreeSum {

    // 双指针法，不过需要先排序，同时要注意去重，去重的方式也很关键
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 0.排序
        Arrays.sort(nums);
        // 1.遍历每个元素作为一次三元组的第一个元素
        for (int i = 0; i <= nums.length-3; i++) {
            // 1.1如果当前元素已经大于0，则后续元素更加大于0，无法相加为0，直接return当前结果
            if(nums[i] > 0){
                return result;
            }
            // 1.2去重，如果当前三元组第一个元素与其前一个元素相等则去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1, right = nums.length-1;
            // 1.3双指针找符合条件的三元组
            while(left<right){
                // 三数之和大于0则right指针左移，小于0则left指针右移
                if(nums[i] + nums[left] + nums[right] > 0){
                   right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    // 等于0时先收获结果
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 而后再对left和right去重
                    while(left<right && nums[right] == nums[right-1]){
                        right--;
                    }
                    while(left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    // 双指针同时移动必须要在去重之后
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
