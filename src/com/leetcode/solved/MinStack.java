package com.leetcode.solved;

import java.util.Stack;

public class MinStack {
	
	public Stack<Integer> valStack = new Stack<Integer>();
	public Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
        valStack.push(x);
        if(minStack.isEmpty()){
        	minStack.push(x);
        }else{
        	minStack.push((minStack.peek() < x) ? minStack.peek() : x );
        }
    }

    public void pop() {
        valStack.pop();
        minStack.pop();
    }

    public int top() {
    	return valStack.peek();
    }

    public int getMin() {
    	return minStack.peek();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
