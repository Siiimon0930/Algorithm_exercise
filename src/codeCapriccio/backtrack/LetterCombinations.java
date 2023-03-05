package codeCapriccio.backtrack;

import java.util.*;

public class LetterCombinations {
    /*
    * 题意（leetcode17. 电话号码的字母组合）：
    *   给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 手机九键。
    * 解题思路：
    *   使用一个map（其实可以用一个String 数组）来保存数字和字母之间的映射，而后就是回溯三部曲
    */

    private Map<Character, List<Character>> dict = new HashMap<>();
    private List<String> res = new ArrayList<>();
    private StringBuilder combine = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return res;
        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        findCombine(digits, 0);
        return res;
    }

    public void findCombine(String digits, int startIndex){
        if(combine.length() == digits.length()){
            res.add(combine.toString());
            return;
        }
        for (int i = startIndex; i < digits.length(); i++) {
            List<Character> currentDict = dict.get(digits.charAt(i));
            for(int j = 0; j < currentDict.size(); j++){
                combine.append(currentDict.get(j));
                findCombine(digits, i+1);
                combine.deleteCharAt(combine.length()-1);
            }
        }
    }
}
