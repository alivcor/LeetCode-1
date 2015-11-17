package com.leetcode.solved;

public class ValidPalindromes {
	/*
	 * Function to check if a given character is AlphaNumeric or not.
	 */
	 private static boolean checkAlphanumeric(char c){
		 return ((c >= 'a' && c <= 'z' ) || (c >= '0' && c <= '9'));
	 }
	 
	 /*
	  * Function to check if a given string is a palindrome or not.
	  * It would start at both the ends and would return false at any mismatch. Else true.
	  */
	 public static boolean isPalindromeUtil(String s, int start, int end) {
			
			if(start >= end) return true;
			
			while(start < end){
				while(start <= end && !checkAlphanumeric(s.charAt(start)))
					start++;
				while(start <= end && !checkAlphanumeric(s.charAt(end)))
					end--;
				
				if(start >= end) return true;
				if(s.charAt(start) != s.charAt(end)) return false;
				start++;
				end--;
			}
			
			return true;
	}
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		return isPalindromeUtil(s,0,s.length()-1);
	}
	public static void main(String[] args) {
		//System.out.println(isPalindrome("abcdcba"));
		System.out.println(isPalindrome("abcddcba"));
		System.out.println(isPalindrome("abcbdcba"));

	}


	

}
