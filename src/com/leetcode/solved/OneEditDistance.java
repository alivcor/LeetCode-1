package com.leetcode.solved;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return (s.length() + t.length() == 1);
        if(s.charAt(0) == t.charAt(0)) return isOneEditDistance(s.substring(1),t.substring(1));
        if(s.length() == t.length()) return s.substring(1).equals(t.substring(1));
        if(s.length() > t.length()) return s.substring(1).equals(t);
        return s.equals(t.substring(1));
        
    }

}
