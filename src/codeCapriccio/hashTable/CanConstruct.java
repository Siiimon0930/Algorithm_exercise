package codeCapriccio.hashTable;

import java.util.HashMap;
import java.util.Map;

public interface CanConstruct {
    /*
    * 题目描述（leetcode383赎金信）：给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
    *   如果可以，返回 true ；否则返回 false
    * 解题思路：
    *   1）遍历magazine，把其中的每个字符用map保存，key为char，value为该字符的次数，
    *   2）而后遍历ransomNote，每个字符去map中查，若存在则对应value-1，若不存在或对应value<=0了则返回false，最终遍历完ransomNote还没返回false则返回true
    * */
    default boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> record = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            Character temp = magazine.charAt(i);
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++){
            Character temp = ransomNote.charAt(i);
            if(!record.containsKey(temp) || record.get(temp) <= 0)
                return false;
            else {
                record.put(temp, record.get(temp) - 1);
            }
        }
        return true;
    }
    // 只由小写字母组成用数组写更快，省去hashmap维护成本
//    public boolean canConstruct(String ransomNote, String magazine) {
//        // 定义一个哈希映射数组
//        int[] record = new int[26];
//
//        // 遍历
//        for(char c : magazine.toCharArray()){
//            record[c - 'a'] += 1;
//        }
//
//        for(char c : ransomNote.toCharArray()){
//            record[c - 'a'] -= 1;
//        }
//
//        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
//        for(int i : record){
//            if(i < 0){
//                return false;
//            }
//        }
//
//        return true;
//
//    }
}
