package codeCapriccio.stackAndQueue;

import java.util.Stack;

/*
* 题目描述:leetcode232. 用栈实现队列
* 解题思路：用两个栈去纯模拟一个队列，两个栈的入口方向相反。
* */

public class MyQueue {

    Stack<Integer> stIn;
    Stack<Integer> stOut;

    public MyQueue() {
        this.stIn = new Stack<>();
        this.stOut = new Stack<>();
    }

    public void push(int x) {
        stIn.push(x);
    }

    public int pop() {
        // 这里注意out栈为空时，要把in栈内的所有元素都pop到stOut中，否则会打乱出队顺序
        if(stOut.empty()){
            while(!stIn.empty()){
                stOut.push(stIn.pop());
            }
        }
        return stOut.pop();
    }

    public int peek() {
        if(stOut.empty()){
            while(!stIn.empty()){
                stOut.push(stIn.pop());
            }
        }
        return stOut.peek();
    }

    public boolean empty() {
        if(stIn.empty() && stOut.empty())
            return true;
        else
            return false;
    }
}
