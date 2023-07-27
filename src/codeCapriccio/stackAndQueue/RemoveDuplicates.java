package codeCapriccio.stackAndQueue;

import java.util.Stack;

/*
* leetcode 1047. 删除字符串中的所有相邻重复项:
*   给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
*   在 S 上反复执行重复项删除操作，直到无法继续删除。
*   在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
* 解题思路：栈解决
*/
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }else
                stack.pop();
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
