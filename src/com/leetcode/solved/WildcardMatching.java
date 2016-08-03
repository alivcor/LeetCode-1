package com.leetcode.solved;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return (s == null && p == null);
        int sIndex = 0;
        int pIndex = 0;
        int lastStrPtr = -1;
        int matchAtStr = -1;
        
        while(sIndex < s.length()){
            if(pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))){
                sIndex++;
                pIndex++;
            }else if(pIndex < p.length() && p.charAt(pIndex) == '*'){
                lastStrPtr = pIndex;
                matchAtStr = sIndex;
                pIndex++;
            }else if(lastStrPtr != -1){
                //not matched, so we will go back and restart from * with one extra char matched.
                matchAtStr++;
                sIndex = matchAtStr;
                pIndex = lastStrPtr+1;
            }
            
            else return false;
        }
        
        while(pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
        return pIndex == p.length();
    }
}
