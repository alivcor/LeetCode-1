package com.leetcode.solved;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        
        int sI = 0;
        int tI = 0;
        while(sI < s.length() && tI < t.length()){
            if(s.charAt(sI) == t.charAt(tI)){
                sI++;
                tI++;
            }else tI++;
        }
        
        return sI == s.length();
    }
}
