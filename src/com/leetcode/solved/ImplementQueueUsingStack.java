package com.leetcode.solved;

import java.util.Stack;
/*
 * The idea is to use two stacks.
 * Use one of them to push values in the LIFO manner. Pop using other.
 * As soon as pop is requested, check if there is any item in the other stack.
 * Yes: Return
 * No: Add all the items from push stack to pop stack.
 * Note that the sequence of insertion would reverse and thus would become FIFO.
 * 
 */
class ImplementQueueUsingStack {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
    	stack1.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty()){
        	fillQueue();
        }
        stack2.pop();
    }

    private void fillQueue() {
		while(!stack1.isEmpty()){
			stack2.add(stack1.pop());
		}
	}

	// Get the front element.
    public int peek() {
    	if(stack2.isEmpty()){
        	fillQueue();
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
    
    public static void main(String args[]){
    	
    	ImplementQueueUsingStack q = new ImplementQueueUsingStack();
    	for(int i = 1; i < 100; i++){
    		if(i%3 == 0){
    			System.out.println(q.peek());
    			q.pop();
    		}else{
    			q.push(i);
    		}
    	}
    }
}
