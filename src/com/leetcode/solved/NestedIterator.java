package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


 interface NestedInteger {
 public boolean isInteger();
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> integerStack; 
    public NestedIterator(List<NestedInteger> nestedList) {
        this.integerStack = new Stack<>();
        if(nestedList == null) return;
        for(int i = nestedList.size()-1; i >= 0; i--) integerStack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
    	return integerStack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
    	while(!integerStack.isEmpty() && !integerStack.peek().isInteger()){
    		List<NestedInteger> topList = integerStack.pop().getList();
    		for(int i = topList.size()-1; i >= 0; i--) integerStack.push(topList.get(i));
    	}
    	return !integerStack.isEmpty();	
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */