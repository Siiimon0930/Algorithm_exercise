package codeCapriccio.string;

public interface ReplaceSpace {
    /*
    * 题目描述（剑指 Offer 05. 替换空格）：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    * 解题思路，就遍历然后替换呀
    * */
    default String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                res.append("%20");
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
