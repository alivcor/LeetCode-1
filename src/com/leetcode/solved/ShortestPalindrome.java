package com.leetcode.solved;

public class ShortestPalindrome {
	public static int[] pre(String s){
		if(s == null) return new int[0];
		int prepr[] = new int[s.length()];
		
		int curLen = 0;
		int i = 1;
		while(i < s.length()){
			if(s.charAt(curLen) == s.charAt(i)){
				curLen++;
				prepr[i] = curLen;
				i++;
			}else if(curLen == 0){
				prepr[i] = 0;
				i++;
			}else{
				curLen = prepr[curLen-1];
			}
		}
		return prepr;
	}
	
	public static String shortestPalindrome(String s){
		if(s == null || s.length() <= 1) return s;
		String revS = new StringBuilder(s).reverse().toString();
		int[] preprocess = pre(s);
		
		int patInd = 0;
		int i = 0;
		while(i < revS.length()){
			if(i == revS.length() - 1){
				return revS.substring(0, s.length() - patInd - 1) + s;
			}
			
			if(revS.charAt(i) == s.charAt(patInd)){
				patInd++;
				i++;
			}
			else{
				if(patInd != 0) patInd = preprocess[patInd - 1];
				else i++;
			}
		}
		
		return (revS + s);
	}

}
