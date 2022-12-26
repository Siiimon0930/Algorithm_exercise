package codeCapriccio.hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface Intersection {
    /*
    * 题目描述（leetcode349）：给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
    * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
    * 解题思路：用两个集合set1，set2记录两个数组出现的数字，而后两个集合的交集就是两个数组的交集
    * 时间复杂度：O（n）空间复杂度：O（n）
    * */
    default int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            set1.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++)
            set2.add(nums2[i]);
        result.addAll(set1);
        result.retainAll(set2);
        int length = result.toArray().length;
        int[] re = new int[length];
        Object[] re2 = result.toArray();
        for(int i = 0;i < length; i++){
            re[i] = (int)re2[i];
        }
        return re;
    }
}
