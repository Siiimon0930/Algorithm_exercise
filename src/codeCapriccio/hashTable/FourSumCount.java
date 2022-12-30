package codeCapriccio.hashTable;

import java.util.HashMap;
import java.util.Map;

public interface FourSumCount {
    /*
    * 题目描述（leetcode454 四数相加Ⅱ）：给你四个整数数组 nums1、nums2、nums3 和 nums4 ，
    *   数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
    *   0 <= i, j, k, l < n, nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
    * 解题思路：
    *   1) 先用一个map来存储nums1和nums2两两元素相加，key为a+b,value为a+b的次数
    *   2）而后遍历nums3和nums4，判断-（c+d）是否在map中出现，若出现则count+=value
    * 时间复杂度：O(n^2)
    * 注意细节：这里为什么选择用map保存前两个数组的和，是因为分为2，2就O(n^2)+O(n^2)=O(n^2),
    * 否则分为1，3的话O(n) + O(n^3) = O(n^3)
    * 暴力法是O(n^4)
    * */

    default int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> AplusB = new HashMap<>();
        int count = 0;
        // 第一个两层循环是遍历nums1和nums2的元素相加
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int temp = nums1[i] + nums2[j];
                AplusB.put(temp, AplusB.getOrDefault(temp, 0) + 1);
            }
        }
        // 遍历nums3和nums4
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                int temp = nums3[i] + nums4[j];
                // 如果哈希表里包含-temp则满足条件，count+=value
                if(AplusB.containsKey(-temp))
                    count += AplusB.get(-temp);
            }
        }

        return count;
    }
}
