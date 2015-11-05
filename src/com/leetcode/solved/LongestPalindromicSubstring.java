package com.leetcode.solved;

public class LongestPalindromicSubstring {
	
	public static boolean isPalindrome(String input){
		
		int index = 0;
		while(index < input.length()-index ){
			if(input.charAt(index) != input.charAt(input.length() - index -1))
					return false;
			index++;
		}
		
		return true;
	}

	public static String longestPalindromeBruteForce(String input){
		
		String longestP = "";
		for(int i = 0; i < input.length(); i++){
			for(int j = i; j < input.length(); j++){
				if(isPalindrome(input.substring(i, j)) && longestP.length() < (j-i+1)){
					longestP = input.substring(i,j+1);
				}
			}
		}
		
		return longestP;
	}
	/*
	 * Dynamic Programming
	 * Idea behind this implementation is that if we have a palindrome and we add same character to both end, the result string is also a Palindrome.
	 * We created a NxN array. Every cell of Array[i,j] would be true if the substring between ith and jth character of the input string is a Palindrome.
	 */
	public static String longestPalindrome(String input){
		
		boolean dpArray[][] = new boolean[input.length()][input.length()];
		
		//Each individual character is a palindrome of length 1.
		for(int i = 0; i < input.length(); i++){
			dpArray[i][i] = true;
		}
		
		int maxS = 0;
		int maxE = 0;
		
		//Checking for 2 length Palindrome
		for(int i = 1; i < input.length(); i++){
			dpArray[i-1][i] = (input.charAt(i-1) == input.charAt(i)) ? true : false;
			if(dpArray[i-1][i]){
				maxS = i-1;
				maxE = i;
			}
		}
		
		for(int i = 0; i < input.length(); i++){
			for(int j = 2; j+i < input.length(); j++){
				int row = j - 2;
				int col = i + j;
				if(input.charAt(row) == input.charAt(col) && dpArray[row+1][col-1] == true){
					dpArray[row][col] = true;
					if (maxE - maxS < col - row) {
						maxS = row;
						maxE = col;
					}
				}
			}
		}
		return input.substring(maxS, maxE+1);
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));
	}

}
