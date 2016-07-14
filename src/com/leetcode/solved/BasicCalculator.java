package com.leetcode.solved;

import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		if(s == null || s.length() == 0) return 0;
		int sum = 0;
		int index = 0;
		Stack<Integer> signStack = new Stack<>();
		signStack.add(1);
		int localSign = 1;
		int curSign = 1;
		while(index < s.length()){
			if(s.charAt(index) == ' '){
				index++;
				continue;
			}
			int curNum = 0;
			while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') curNum = curNum*10 + s.charAt(index++) - '0';
			sum += curSign*localSign*curNum;
			if(index < s.length()){
				if(s.charAt(index) == '('){
					signStack.push(localSign);
					curSign *= localSign;
					localSign = 1;
				}
				else if(s.charAt(index) == ')'){
					curSign *= signStack.pop();
				}
				else if(s.charAt(index) == '+') localSign = 1;
				else localSign = -1;
				index++;
			}
		}
		return sum;
    }

}
