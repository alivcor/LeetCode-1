package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParetheses {
	public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        Stack<Character> stk = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
              if(stk.isEmpty() || stk.pop() != map.get(s.charAt(i))) return false;
            }else stk.push(s.charAt(i)); 
        }
        return stk.isEmpty();
    }

}
