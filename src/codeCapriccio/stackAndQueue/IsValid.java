package codeCapriccio.stackAndQueue;

import java.util.Stack;

/*
* leetcode20. 有效的括号:
*   给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
*   有效字符串需满足：
*       左括号必须用相同类型的右括号闭合
*       左括号必须以正确的顺序闭合。
*       每个右括号都有一个对应的相同类型的左括号。
* 解题思路：一个栈解决，左括号push右pop
*/
public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    // 如果遇到右括号栈为空则直接return false
                    return false;
                char cc = stack.pop();
                // 括号不匹配返回false
                if(c == ')' && cc != '(')
                    return false;
                else if (c == ']' && cc != '[') {
                    return false;
                } else if (c == '}' && cc != '{') {
                    return false;
                }
            }
        }
        // 遍历完后不可以有多余的左括号还在栈内
        return stack.isEmpty();
    }
}
