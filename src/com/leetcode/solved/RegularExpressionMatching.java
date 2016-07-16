package com.leetcode.solved;

public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		if(p.length() > 1 && p.charAt(1) == '*'){
			return ((s.isEmpty() && p.length() == 2) 
					|| (s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p))
					|| isMatch(s, p.substring(2))
					);
		}
		if(s.isEmpty()) return false;
		if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) return isMatch(s.substring(1), p.substring(1));
		return false;
    }
	public static void main(String[] args) {
		System.out.println(isMatch("abdefc", ".*c")); 

	}

}
