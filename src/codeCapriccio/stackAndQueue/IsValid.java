package codeCapriccio.stackAndQueue;

public interface IsValid {
    /*
    * 题目描述（leetcode20. 有效的括号）：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    * 解题思路：左括号入栈，右括号pop栈，若pop的和右括号不匹配则失败，中间不失败且最终栈是空的才成功
    * 时间复杂度：O（n）
    * */
    static boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;
        char[] stack = new char[s.length()];
        int length = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack[length++] = s.charAt(i);
            }else {
                if(length < 1)
                    return false;
                char popValue = stack[--length];
                if(s.charAt(i) == ')' && popValue != '(')
                    return false;
                if(s.charAt(i) == ']' && popValue != '[')
                    return false;
                if(s.charAt(i) == '}' && popValue != '{')
                    return false;
            }
        }

        return length == 0;
    }
}
