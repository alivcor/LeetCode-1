package com.leetcode.solved;

import java.util.Stack;

public class ID439_TernaryExpressionParser {
	public String parseTernary(String exp) {
        if(exp == null || exp.length() == 0) return "";
        Stack<String> evalStack = new Stack<>();
        String[] split = exp.split(":");
        for(int i = split.length - 1; i >= 0; i--){
            if(split[i].indexOf("?") == -1) evalStack.add(split[i]);
            else {
                String eval[] = split[i].split("\\?");
                evalStack.add(eval[eval.length - 1]);
                for(int j = eval.length - 2; j >= 0; j--){
                    if("T".equals(eval[j])){
                        String top = evalStack.pop();
                        //pop the second value in stack
                        evalStack.pop();
                        evalStack.add(top);
                    }else{
                        evalStack.pop();
                    }
                }
            }
        }
        
        return evalStack.pop();
    }

}
