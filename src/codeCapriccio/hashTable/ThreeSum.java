package codeCapriccio.hashTable;

import java.util.*;

public interface ThreeSum {
    /*
    * 题目描述（leetcode15. 三数之和）:
    *   给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    *   同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    * 解题思路：
    *   1. 暴力法（n^3):三层循环
    *   2. 哈希法（n^2)（需要去重，去重很麻烦,并且会超时）：用一个map存nums[i]+nums[j]的结果，key为和，value为List<List<Integer>>
    *   3. 双指针法
    * */
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<List<Integer>>> record = new HashMap<>();
        int temp;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                temp = nums[i] + nums[j];
                List<Integer> tuple = Arrays.asList(i, j);
                if(record.containsKey(temp)){
                    record.get(temp).add(tuple);
                }else{
                    List<List<Integer>> value = new ArrayList<>();
                    value.add(tuple);
                    record.put(temp, value);
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(record.containsKey(-nums[i])){
                for (List<Integer> tuple: record.get(-nums[i])) {
                    if(!tuple.contains(i)){
                        res.add(Arrays.asList(nums[tuple.get(0)], nums[tuple.get(1)], nums[i]));
                    }
                }
            }
        }
        // 缺少一步去重，这一步不好写
        for(List<Integer> tuple: res){
            tuple.sort((a, b) -> a-b);
        }
        Set<List<Integer>> setRes = new HashSet<>(res);
        res.clear();
        res.addAll(setRes);
        return res;
    }
    // 双指针法
//    default List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        // 找出a + b + c = 0
//        // a = nums[i], b = nums[left], c = nums[right]
//        for (int i = 0; i < nums.length; i++) {
//            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
//            if (nums[i] > 0) {
//                return result;
//            }
//
//            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
//                continue;
//            }
//
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (right > left) {
//                int sum = nums[i] + nums[left] + nums[right];
//                if (sum > 0) {
//                    right--;
//                } else if (sum < 0) {
//                    left++;
//                } else {
//                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
//                    while (right > left && nums[right] == nums[right - 1]) right--;
//                    while (right > left && nums[left] == nums[left + 1]) left++;
//
//                    right--;
//                    left++;
//                }
//            }
//        }
//        return result;
//    }
}
