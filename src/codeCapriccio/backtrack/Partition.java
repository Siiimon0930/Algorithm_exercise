package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    /*
    * 题意（leetcode131. 分割回文串）：
    *   给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
        回文串：是正着读和反着读都一样的字符串。
    * 解题思路：
    *   整体思路和组合问题一致，用startIndex表示每一层切割的起点，（startIndex，i】表示子串
    */

    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return res;
        findPath(s, 0);
        return res;
    }

    private void findPath(String s, int startIndex){
        // 终止条件是切到最后了，也就是startIndex >= s.length
        if(startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isPalindrome(s, startIndex, i)){
                String sub = s.substring(startIndex, i + 1);
                path.add(sub);
            }
            else
                continue;
            findPath(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
