package codeCapriccio.string;

public interface RepeatedSubstringPattern {
    /*
    * 题目描述（leetcode459. 重复的子字符串）：给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    *   如：“abab”true，“aba”false
    * 解题思路：
    *   1. 暴力法：这个子串肯定是从下标为0开是子串，且子串长度肯定<=字符串长度的一半,故用两个for循环去找（O(n^2)）
    *   2. 移动匹配法：简单说就是如果一个字符串s可由多个子串重复构成，则s'=s+s,s'中一定会出现s
    *   3. kmp法，见代码随想录。
    * */
    // 1. 暴力法
//    default boolean repeatedSubstringPattern(String s) {
//        for(int i = s.length() / 2; i > 0; i--){
//            String subStr = s.substring(0, i);
//            if(s.length() % subStr.length() != 0)   // 父串的长度必须是子串的整数倍
//                continue;
//            else{
//                for(int j = 0; j < s.length(); j++){
//                    if(s.charAt(j) != subStr.charAt(j%subStr.length())){
//                        break;
//                    }
//                    if(j == s.length() - 1)     // 比较到最后一个字符且没break则说明是符合条件的子串
//                        return true;
//                }
//            }
//        }
//        return false;
//    }
    // 2. 移动匹配法  （这个竟然还没暴力法快）
    default boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        if(ss.substring(1, ss.length()-1).contains(s)){
            return true;
        }else {
            return false;
        }
    }
}
