package codeCapriccio.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

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
    // 更巧妙的小trick：在push的时候先判断是什么左括号，然后push对应的右括号进去，而后在碰到右括号时就直接比对栈顶元素是否与当前元素相等即可，无需三个if了。
//    public boolean isValid(String s) {
//        Deque<Character> deque = new LinkedList<>();
//        char ch;
//        for (int i = 0; i < s.length(); i++) {
//            ch = s.charAt(i);
//            //碰到左括号，就把相应的右括号入栈
//            if (ch == '(') {
//                deque.push(')');
//            }else if (ch == '{') {
//                deque.push('}');
//            }else if (ch == '[') {
//                deque.push(']');
//            } else if (deque.isEmpty() || deque.peek() != ch) {
//                return false;
//            }else {//如果是右括号判断是否和栈顶元素匹配
//                deque.pop();
//            }
//        }
//        //最后判断栈中元素是否匹配
//        return deque.isEmpty();
//    }
}
