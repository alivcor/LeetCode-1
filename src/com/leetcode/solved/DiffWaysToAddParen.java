package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiffWaysToAddParen {
	public static List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0) return new ArrayList();
        List<Integer> result = diffWaysToCompute(input,0,input.length()-1);
        Collections.sort(result);
        return result;
    }
    
    private static boolean isOperator(char o){
        return (o == '+' || o == '-' || o == '*');
    }
    
    private static int operate(int a, int b, char o){
        switch(o){
            case '+': return (a + b);
            case '-': return (a - b);
        }
        
        return (a * b);
    }
    private static List<Integer> calculate(List<Integer> l1, List<Integer> l2, char o){
        List<Integer> result = new ArrayList();
        if(l1 == null || l2 == null || l1.size() == 0 || l2.size() == 0) return result;
        
        for(int i : l1){
            for(int j : l2){
                result.add(operate(i,j,o));
            }
        }
        
        return result;
    }
    private static List<Integer> diffWaysToCompute(String input, int start, int end) {
        List<Integer> result = new ArrayList();
        boolean hasOperator = false;
        
        for(int i = start; i <= end; i++){
            if(isOperator(input.charAt(i))){
                hasOperator = true;
                result.addAll(calculate(diffWaysToCompute(input,start, i-1), diffWaysToCompute(input, i+1, end), input.charAt(i))); 
            }
        }
        if(!hasOperator){
            result.add(Integer.parseInt(input.substring(start,end+1)));
        }
        return result;        
    }
	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2-1-1"));

	}

}
