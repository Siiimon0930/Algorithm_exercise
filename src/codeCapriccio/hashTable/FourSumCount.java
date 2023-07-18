package codeCapriccio.hashTable;

import java.util.HashMap;
import java.util.Map;

/*
* leetcode454. 四数相加 II:
*   给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
*       0 <= i, j, k, l < n
*       nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
* 解题思路：
*   把nums1和nums2所有元组组合存入map<sum,freq>中，而后在遍历nums3和nums4时查询map中是否有sum=-（nums3[i]+nums4[j]），
*   这样时间复杂度时O（n2）
*/
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        // 遍历nums1和nums2
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        // 遍历nums3和nums4
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                sum = nums3[i] + nums4[j];
                if(map.containsKey(-sum))
                    result += map.get(-sum);
            }
        }

        return result;
    }
}
