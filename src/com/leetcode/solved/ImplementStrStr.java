package com.leetcode.solved;

import java.util.Arrays;

public class ImplementStrStr {
	
	public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null ||
        		haystack.length() < needle.length()) return -1;
        if(needle.length() == 0) return 0;
        
        int pparray[] = preprocessPattern(needle);
        int currIndex = 0;
        int matchIndex = 0;
        
        while(currIndex < haystack.length()){
        	if(haystack.charAt(currIndex) == needle.charAt(matchIndex)){
        		currIndex++;
        		matchIndex++;
        		if(matchIndex == needle.length()) return currIndex - matchIndex;
        	}else{
        		
        		if(matchIndex == 0) currIndex++;
        		else matchIndex = pparray[matchIndex-1];
        		 
        	}
        }
        
        return -1;
    }
	
	private static int[] preprocessPattern(String pattern){
		if(pattern == null || pattern.length() == 0) return new int[0];
		
		int preprocess[] = new int[pattern.length()];
		int currentI = 1;
		
		while(currentI < pattern.length()){
			if(pattern.charAt(currentI) == pattern.charAt(preprocess[currentI-1])) {
				preprocess[currentI] = preprocess[currentI-1] + 1;
				currentI++;
			}
			else{
				preprocess[currentI++] = 0;
			}
		}
		return preprocess;
	}
	public static void main(String[] args){
		
//		System.out.println(strStr("CAABAACAADAABAAABAA", "AABA"));
//		System.out.println(strStr("THIS IS A TEST TEXT", "TEST"));
//		System.out.println(strStr("ABABDABACDABABCABAB", "ABABCABAB"));
		System.out.println(strStr("mississippi", "issip"));
		
		
	}

}
