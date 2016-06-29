package com.leetcode.solved;

import java.util.Stack;

public class BasicCalculator2 {

	private static String removeSpace(String s){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') sb.append(s.charAt(i));
		return sb.toString();
	}
	public static int calculate(String val){
		if(val == null || val.length() == 0) return 0;
		val = removeSpace(val);
		Stack<Integer> stack = new Stack<>();
		
		int index = 0;
		int prev = 0;
		while(index < val.length()){
			char operator = '+';
			if(val.charAt(index) == '+' || val.charAt(index) == '-' ||
					val.charAt(index) == '*' || val.charAt(index) == '/'){
				operator = val.charAt(index++);
			}
			while(index < val.length() && val.charAt(index) >= '0' && val.charAt(index) <= '9'){
				prev = 10*prev + val.charAt(index++) - '0';
			}
			if(operator == '+') stack.add(prev);
			else if(operator == '-') stack.add(-1 * prev);
			else if(operator == '*') stack.add(stack.pop() * prev);
			else if(operator == '/') stack.add(stack.pop() / prev);
			prev = 0;
		}
		int sum = 0;
		while(!stack.isEmpty()) sum += stack.pop();
		return sum;
	}
}
