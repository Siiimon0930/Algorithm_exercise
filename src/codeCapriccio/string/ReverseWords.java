package codeCapriccio.string;

public interface ReverseWords {
    /*
    * 题目描述（leetcode151. 反转字符串中的单词）：输入：s = "  hello world  " 输出："world hello"
    * 解题思路：先trim 然后在遍历append到一个StringBuilder去
    * */
    // 空间复杂度O(n)
    default String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' && s.charAt(i+1) != ' '){
                res.insert(0, " " + s.substring(start, i).trim());
                start = i + 1;
            }
        }
        res.insert(0, s.substring(start, s.length()));
        return res.toString();
    }

}
