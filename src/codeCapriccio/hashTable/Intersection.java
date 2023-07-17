package codeCapriccio.hashTable;

import java.util.HashSet;

/*
* leetcode349. 两个数组的交集:
* 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
* 解题思路：用一个hashset记录num1中出现的数字，遍历num2时去hashset中查
*/
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        // 1.遍历num1
        for (int i : nums1) {
            hashSet.add(i);
        }
        // 2.遍历num2
        for (int i : nums2) {
            if(hashSet.contains(i))
                temp.add(i);
        }
        // 把hashset转为int数组
        int[] result = temp.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
