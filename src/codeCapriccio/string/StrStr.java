package codeCapriccio.string;

public interface StrStr {
    /*
    * 题目描述（leetcode：28. 找出字符串中第一个匹配项的下标）
    *   给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    *   如果needle 不是 haystack 的一部分，则返回 -1 。
    * 解题思路：
    *   1. 遍历一遍过去，每次循环比较当前index开始的子串和needle是否一样(时间复杂度O(n*l),l是needle的长度)
    *   2. kmp法: next数组的代码没搞懂，时间复杂度O（m+n）
    * */
    // 暴力法
    static int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return -1;
        if(haystack.equals(needle))
            return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            String sub = haystack.substring(i, i+needle.length());
            if(sub.equals(needle))
                return i;
        }
        return -1;
    }

    // kmp法
//    public int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//        int[] next = new int[needle.length()];
//        getNext(next, needle);
//
//        int j = 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
//                j = next[j - 1];
//            if (needle.charAt(j) == haystack.charAt(i))
//                j++;
//            if (j == needle.length())
//                return i - needle.length() + 1;
//        }
//        return -1;
//
//    }
//
//    private void getNext(int[] next, String s) {
//        int j = 0;
//        next[0] = 0;
//        for (int i = 1; i < s.length(); i++) {
//            while (j > 0 && s.charAt(j) != s.charAt(i))
//                j = next[j - 1];
//            if (s.charAt(j) == s.charAt(i))
//                j++;
//            next[i] = j;
//        }
//    }
}
