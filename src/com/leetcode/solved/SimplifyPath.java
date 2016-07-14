package com.leetcode.solved;

import java.util.Stack;

public class SimplifyPath {

	public static String simplifyPath(String path) {
		if(path == null || path.length() == 0) return "";
		String[] splitArray = path.split("/");
		Stack<String> stk = new Stack<>();
		for(int i = 0; i < splitArray.length; i++){
			if(".".equals(splitArray[i]) || "".equals(splitArray[i]))continue;
			else if("..".equals(splitArray[i])){
				if(!stk.isEmpty()) stk.pop();
			}
			else stk.push(splitArray[i]);
		}
		
		StringBuilder result = new StringBuilder();
		while(!stk.isEmpty()) result.insert(0,"/" + stk.pop());
		return ((result.length() == 0) ? "/" : result.toString());
    }
}
