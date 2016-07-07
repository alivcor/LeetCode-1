package com.leetcode.solved;

import java.util.Stack;

public class LongestValidParantheses {
	public static int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) return 0;
        Stack<Integer> stackIndx = new Stack<>();
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '(') stackIndx.push(i);
        	else{
        		if(stackIndx.isEmpty() || s.charAt(stackIndx.peek()) == ')') stackIndx.push(i);
        		else stackIndx.pop();
        	}
        }
        
        int maxSubStrLen = 0;
        if(stackIndx.isEmpty()) return s.length();
        int prev = s.length();
        while(!stackIndx.isEmpty()){
        	int temp = stackIndx.pop(); 
        	maxSubStrLen = Integer.max(maxSubStrLen, prev - temp - 1);
        	prev = temp;
        }
        
        return Integer.max(maxSubStrLen, prev);
    }

}
