package com.priest.stack;

import java.util.Stack;

/**
 * 详情 : 用栈实现队列
 * <p>
 * 详细 : https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author liangguanglong 2019/7/12
 */
public class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;


    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer peek = s1.peek();
        s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return peek;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
