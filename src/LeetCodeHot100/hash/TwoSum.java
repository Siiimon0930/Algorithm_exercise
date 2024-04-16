package LeetCodeHot100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1.两数之和
 * @Author: Siiimon
 * @Date: 2024/04/16/11:29
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 遍历数组，使用map存储当前元素，key为元素值，value为下标
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
