package com.leetcode.solved;

import java.util.Stack;

public class RemoveKDigits {
	    public static String removeKdigits(String num, int k){
	        String result = removeK(num, k);
	        return trimVal(result);
	    }

	    public static String removeK(String num, int k) {
	        if(k == 0) return num;
	        if(num == null || num.length() == k) return "0";
	        Stack<Character> stack = new Stack<>();
	        int index = 1;
	        stack.add(num.charAt(0));
	        while(index <= num.length() - 1 && k > 0){
	            if(num.charAt(index) >= stack.peek()){
	                stack.add(num.charAt(index));
	                index++;
	            }else{
	                while(k > 0 && !stack.isEmpty() && num.charAt(index) < stack.peek()){
	                    
	                    stack.pop();
	                    k--;    
	                }
	                stack.add(num.charAt(index++));
	            }
	            
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        while(!stack.isEmpty()) sb.append(stack.pop());
	        sb.reverse();
	        sb.append(num.substring(index));
	        return sb.toString().substring(0,sb.length() - k);
	    }
	    
	    
	    private static String trimVal(String result){
	        while(result.length() >= 1 && result.charAt(0) == '0') result = result.substring(1);
	        return ("".equals(result)) ? "0" : result;
	    }
	

	public static void main(String[] args) {
		System.out.println(removeKdigits("10", 1));

	}

}
