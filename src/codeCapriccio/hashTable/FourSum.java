package codeCapriccio.hashTable;

import java.util.*;

public interface FourSum {
    /*
    * 题目描述（leetcode18. 四数之和）：给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
    *   请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
        0 <= a, b, c, d< n
        a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。

    * 解题思路：哈希法，最后用一个set去重。
    * */
    // 1. 哈希法（超时）
    default List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Map<Integer, List<List<Integer>>> record = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                List<Integer> temp = Arrays.asList(i, j);
                if(record.containsKey(sum)){
                    record.get(sum).add(temp);
                }else {
                    List<List<Integer>> tempValue = new ArrayList<>();
                    tempValue.add(temp);
                    record.put(sum, tempValue);
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = target- nums[i] - nums[j];
                if(record.containsKey(sum)){
                    for(List<Integer> tuple: record.get(sum)){
                        if(!tuple.contains(i) && !tuple.contains(j)){
                            List<Integer> item = Arrays.asList(nums[tuple.get(0)], nums[tuple.get(1)], nums[i], nums[j]);
                            item.sort((a, b) -> a-b);
                            res.add(item);
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
    // 双指针法
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//
//            // nums[i] > target 直接返回, 剪枝操作
//            if (nums[i] > 0 && nums[i] > target) {
//                return result;
//            }
//
//            if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
//                continue;
//            }
//
//            for (int j = i + 1; j < nums.length; j++) {
//
//                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
//                    continue;
//                }
//
//                int left = j + 1;
//                int right = nums.length - 1;
//                while (right > left) {
//                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
//                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
//                    if (sum > target) {
//                        right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        // 对nums[left]和nums[right]去重
//                        while (right > left && nums[right] == nums[right - 1]) right--;
//                        while (right > left && nums[left] == nums[left + 1]) left++;
//
//                        left++;
//                        right--;
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
