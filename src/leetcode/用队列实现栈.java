package leetcode;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

// @solution-sync:begin
class MyStack {
    private Queue<Integer> a;//输入队列
    private Queue<Integer> b;//输出队列

    /** Initialize your data structure here. */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while(!b.isEmpty()) {
            a.offer(b.poll());
        }
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        Queue temp = a;
        a = b;
        b = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return b.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return b.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return b.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */