package codeCapriccio.hashTable;

import java.util.HashMap;
import java.util.HashSet;

/*
* leetcode242. 有效的字母异位词:
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
* 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
* 解题思路：设置一个hashmap记录字母的出现次数，其中遍历s时增加次数，遍历t时减少，最终看hashmap中是不是都是0；（设定一个数组来存储频率也是可以的）
*/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 1.遍历s，频次+
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }
        // 2.遍历t，频次-
        for (char c : t.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0)-1);
        }
        // 3.遍历hashmap，value都为0才符合条件
        for (Integer value : hashMap.values()) {
            if(value != 0)
                return false;
        }

        return true;
    }
}
