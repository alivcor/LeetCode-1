package com.leetcode.solved;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0) return 0;
		if(tokens.length == 1) return Integer.parseInt(tokens[0]);
		
		Stack<Integer> stk = new Stack<>();
		for(int i = 0; i < tokens.length; i++){
			if("+".equals(tokens[i])){
				stk.push(stk.pop() + stk.pop());
			}else if("-".equals(tokens[i])){
				stk.push(-1*stk.pop() + stk.pop());
			}else if("*".equals(tokens[i])){
				stk.push(stk.pop() * stk.pop());
			}else if("/".equals(tokens[i])){
				int den = stk.pop();
				stk.push((stk.pop()/den));
			}else{
				stk.push(Integer.parseInt(tokens[i]));
			}
		}
		return stk.pop();
    }

}
