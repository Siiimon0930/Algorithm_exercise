package LeetCodeHot100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 128.最长连续序列
 * @Author: Siiimon
 * @Date: 2024/04/16/11:53
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 数组长度为0，直接返回0
        if(nums.length == 0)
            return 0;
        // 先使用一个set存储数组的元素
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int result = 1;
        for(int num: nums){
            // 当前元素为num，如果num+1不存在则无需探究这个元素，如果num-1存在，则以num为起始肯定短于num-1为起始，故也跳过
            if(!set.contains(num+1) || set.contains(num-1)){
                continue;
            }else {
                // 当前元素为起始，一直+1往前数看是否在set中
                int cur = num;
                while(set.contains(cur)){
                    cur++;
                }
                int length = cur - num;
                if (length > result){
                    result = length;
                }
            }
        }
        return result;
    }
}
