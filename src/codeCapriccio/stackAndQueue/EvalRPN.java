package codeCapriccio.stackAndQueue;

import java.util.Stack;

/*
* leetcode150. 逆波兰表达式求值:
*   输入：tokens = ["2","1","+","3","*"]
*   输出：9
*   解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
* 解题思路：使用栈，数字push，运算符pop两个数运算后再push
*   注意：应该使用equals方法判断，不使用==
*/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")){
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left + right);
            } else if(tokens[i].equals("-")){
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left - right);
            } else if(tokens[i].equals("*")){
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left * right);
            } else if(tokens[i].equals("/")){
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left / right);
            } else
                stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
}
