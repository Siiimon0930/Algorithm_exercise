package codeCapriccio.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;


public interface EvalRPN {
    /*
    * 题目描述（leetcode150. 逆波兰表达式求值:输入：tokens = ["2","1","+","3","*"] 输出：9 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9）
    * 解题思路：碰到数字就入栈，碰到运算符就出栈两个数字进行计算，而后讲计算结果入栈
    * */
    default int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }



}
