package codeCapriccio.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    Queue<Integer> que1;
    Queue<Integer> que2;


    public MyStack() {
        this.que1 = new ArrayDeque<>();
        this.que2 = new ArrayDeque<>();
    }

    public void push(int x) {
        que1.offer(x);
    }

    public int pop() {
        while(que1.size() > 1){
            que2.offer(que1.poll());
        }
        int value = que1.poll();
        while(!que2.isEmpty()){
            que1.offer(que2.poll());
        }
        return value;
    }

    public int top() {
        while(que1.size() > 1){
            que2.offer(que1.poll());
        }
        int value = que1.poll();
        while(!que2.isEmpty()){
            que1.offer(que2.poll());
        }
        que1.offer(value);
        return value;
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}
