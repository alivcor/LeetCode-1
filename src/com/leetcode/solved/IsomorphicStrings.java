package com.leetcode.solved;

import java.util.HashMap;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
    
		if(s == null || t == null)
			return (s == null && t == null);
		if(s.length() != t.length()) return false;
		HashMap<Character, Character> mapChar = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(mapChar.get(s.charAt(i)) == null){
				if(mapChar.containsValue(t.charAt(i))) return false;
				mapChar.put(s.charAt(i), t.charAt(i));
			}else if(mapChar.get(s.charAt(i)) != t.charAt(i)){
				return false;
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		System.out.println(isIsomorphic("paper", "title"));

	}

}
