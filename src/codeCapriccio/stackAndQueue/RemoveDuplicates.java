package codeCapriccio.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public interface RemoveDuplicates {
    /*
    * 题目描述（leetcode1047. 删除字符串中的所有相邻重复项:）输入："abbaca" 输出："ca"
    * 解题思路：遍历一遍字符串，与栈顶元素不同则push，相同则pop，最终栈剩余的元素就是答案字符串
    * 时间复杂度：O（n）
    * */
    default String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(res.length() == 0 || res.charAt(res.length() - 1) != s.charAt(i))
                res.append(s.charAt(i));
            else
                res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
