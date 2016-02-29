package com.leetcode.solved;

public class EditDistance {

	private static int costReplace(char a, char b){
		if(a == b) return 0;
		return 1;
	}
	public static int minDistance(String word1, String word2) {
		if(word1 == null || word2 == null){
			if(word1 == null && word2 == null) return 0;
			if(word1 == null) return word2.length();
			return word1.length();
		}
		
		int dpArray[][] = new int[word1.length() + 1][word2.length() + 1];
		for(int i = 0; i < dpArray.length; i++) dpArray[i][0] = i;
		for(int i = 0; i < dpArray[0].length; i++) dpArray[0][i] = i;
		
		for(int i = 1; i < dpArray.length; i++){
			for(int j = 1; j < dpArray[0].length; j++){
				dpArray[i][j] = Integer.min(dpArray[i-1][j-1] + costReplace(word1.charAt(i-1), word2.charAt(j-1)),
						1 + Integer.min(dpArray[i-1][j], dpArray[i][j-1]));
			}
		}
		
		return dpArray[word1.length()][word2.length()];
    }
	public static void main(String[] args) {
		System.out.println(minDistance("abcd", "acd"));

	}

}
