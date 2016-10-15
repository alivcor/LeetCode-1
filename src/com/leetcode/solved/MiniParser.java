package com.leetcode.solved;


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0) return null;
        if(s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        
        int l = 0;
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int left = 0;//start of number
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            if(ch == '['){
                if(curr != null) stack.push(curr);
                curr = new NestedInteger();
                l = r + 1;
            }else if(ch == ']'){
                String value = s.substring(l,r);
                if(!value.isEmpty()) curr.add(new NestedInteger(Integer.valueOf(value)));
                if(!stack.isEmpty()){
                    stack.peek().add(curr);
                    curr = stack.pop();
                } 
                l = r + 1;
            }else if(ch == ','){
                if(s.charAt(r-1) != ']'){
                    String value = s.substring(l,r);
                    curr.add(new NestedInteger(Integer.valueOf(value)));
                }
                l = r + 1;
            }
        }
        return curr;
        
    }
}