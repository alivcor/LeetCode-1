package com.leetcode.solved;

public class InterleavingString {

	public static boolean isInterleave(String s1, String s2, String s3){
		if(s1 == null || s2 == null){
			if(s1 == null && s2 == null) return (s3 == null);
			if(s3 == null) return (s1 == null && s2 == null);
			if(s1 == null) return (s3.equals(s2));
			return (s3.equals(s1));
		}
		
		if(s1.length() + s2.length() != s3.length()) return false;
		boolean dpMat[][] = new boolean[s1.length() + 1][s2.length() + 1];
		for(int i = 1; i <= s1.length(); i++){
			if(s1.charAt(i-1) == s3.charAt(i-1)) dpMat[i][0] = true;
			else break;
		}
		for(int i = 1; i <= s2.length(); i++){
			if(s2.charAt(i-1) == s3.charAt(i-1)) dpMat[0][i] = true;
			else break;
		}
		
		for(int i = 1; i <= s1.length(); i++){
			for(int j = 1; j <= s2.length(); j++){
				dpMat[i][j] = ((dpMat[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1))||
						(dpMat[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j - 1)));
			}
		}
		
		return dpMat[s1.length()][s2.length()];
	}
}
