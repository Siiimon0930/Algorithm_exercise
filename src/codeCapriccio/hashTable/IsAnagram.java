package codeCapriccio.hashTable;

import java.util.HashMap;
import java.util.Map;

public interface IsAnagram {
    /*
    * 题目描述（leetcode242）：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    * 解题思路：用一个哈希表计算第一个字符串s每个字母出现的频率，而后比对t的字母频率
    * 时间复杂度：O（n）
    * */
    // 数组法
//    default boolean isAnagram(String s, String t) {
//        int[] hash = new int[26];
//        for(int i = 0; i < s.length(); i++)
//            hash[s.charAt(i) - 'a']++;
//        for(int i = 0; i < t.length(); i++)
//            hash[t.charAt(i) - 'a']--;
//        for(int i = 0; i < 26; i++){
//            if(hash[i] != 0)
//                return false;
//        }
//        return true;
//    }
    // hashMap法
    default boolean isAnagram(String s, String t) {
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        for(int i = 0; i < t.length(); i++)
            hash.put(t.charAt(i), hash.getOrDefault(t.charAt(i), 0) - 1);
        for(int i : hash.values()){
            if(i != 0)
                return false;
        }
        return true;
    }
}
