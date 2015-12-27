package com.leetcode.solved;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		MyStack stk = new MyStack();
		stk.push(1);
		stk.push(2);
		System.out.println(stk.top());
		stk.push(4);
		stk.push(5);

	}

}

class MyStack {
	Queue<Integer> q1;
	Queue<Integer> q2;
    // Push element x onto stack.
	//Maintaining element like a stack
    public void push(int x) {
    	if(q1 == null) q1 = new LinkedList<>();
    	if(q2 == null) q2 = new LinkedList<>();
        while(!q1.isEmpty()) q2.add(q1.remove());
    	q1.add(x);
    	while(!q2.isEmpty()) q1.add(q2.remove());
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q1.isEmpty()) q1.remove();
    }

    // Get the top element.
    public int top() {
    	return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
    }
}

//1,2,3,4 -> 1,2,3,4