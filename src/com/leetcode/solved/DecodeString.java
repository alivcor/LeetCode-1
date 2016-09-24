package com.leetcode.solved;

import java.util.Stack;

public class DecodeString {
	private String replicateString(String s, int count){
        StringBuilder sb = new StringBuilder();
        while(count-- > 0) sb.append(s);
        return sb.toString();
    }
    public String decodeString(String s) {
        String result = "";
        Stack<Integer> countStk = new Stack<>();
        Stack<String> resultStk = new Stack<>();
        
        int index = 0;
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))) count = count*10 + (s.charAt(index++) - '0');
                countStk.push(count);
                index--;
            }else if(s.charAt(index) == '['){
                resultStk.add(result);
                result = "";
            }else if(s.charAt(index) == ']'){
                result = resultStk.pop() + replicateString(result, countStk.pop());
            }else result += s.charAt(index);
            
            index++;
        }
        return result;
    }
    
}
