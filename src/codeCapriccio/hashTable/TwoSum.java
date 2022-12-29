package codeCapriccio.hashTable;

import java.util.HashMap;
import java.util.Map;

public interface TwoSum {
    /*
    * 题目描述（leetcode1）：给定一个整数数组 nums 和一个整数目标值 target，
    * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    * 解题思路：
    *   1. 暴力解法（两层循环）O（n^2）
    *   2. map中的存储结构为 {key：数据元素，value：数组元素对应的下表}。
    *       在遍历数组的时候，只需要向map去查询是否有和目前遍历元素比配的数值，
    *       如果有，就找到的匹配对，如果没有，就把目前遍历的元素放进map中，因为map存放的就是我们访问过的元素。
    * */
    // 1. 暴力法
//    default int[] twoSum(int[] nums, int target){
//        int[] result = new int[2];
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                if(nums[i] + nums[j] == target){
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//        return result;
//    }

    // 2. map法
    default int[] twoSum(int[] nums, int target){
        int [] result = new int[2];
        Map<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(record.containsKey(target - nums[i])){
                result[0] = record.get(target - nums[i]);
                result[1] = i;
                break;
            }else {
                record.put(nums[i], i);
            }
        }
        return result;
    }
}
