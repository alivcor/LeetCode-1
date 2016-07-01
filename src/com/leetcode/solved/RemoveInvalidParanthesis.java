package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParanthesis {
	public static boolean isValid(String s){
		int val = 0;
		for(int i = 0; i < s.length() && val >= 0; i++){
			if(s.charAt(i) != ')' && s.charAt(i) != '(') continue;
			val += ((s.charAt(i) == '(') ? 1 : -1);
		}
		return val == 0;
	}
	public static List<String> removeInvalidParentheses(String s){
		if(s == null) return Collections.emptyList();
		List<String> result = new ArrayList<String>();
		Set<String> contained = new HashSet<>();
		
		Queue<String> queue = new LinkedList<>();
		queue.add(s);
		int maxLen = Integer.MIN_VALUE;
		while(!queue.isEmpty() && queue.peek().length() > 0){
			String top = queue.poll();
			if(top.length() < maxLen && isValid(top)) break;
			if(isValid(top)){
				result.add(top);
				maxLen = top.length();
			}else{
				for(int i = 0; i < top.length(); i++){
					if(top.charAt(i) != ')' && top.charAt(i) != '(') continue;
					if(contained.contains(top.substring(0,i) + top.substring(i+1, top.length()))) continue;
					queue.add(top.substring(0,i) + top.substring(i+1, top.length()));
					contained.add(top.substring(0,i) + top.substring(i+1, top.length()));
				}
			}
		}
		if(result.size() == 0) result.add("");
		return result;
	}


	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("(()a"));
		System.out.println(removeInvalidParentheses(")(a"));
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses(""));
		System.out.println(removeInvalidParentheses("()(a"));

	}

}
