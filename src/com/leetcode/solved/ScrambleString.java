package com.leetcode.solved;


public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {
		if(s1 == null || s2 == null) return (s1 == null && s2 == null);
		if(s1.equals(s2)) return true;
		if(s1.length() != s2.length()) return false;

		int[] letters = new int[26];
		for(int i = 0; i < s1.length(); i++){
			letters[s1.charAt(i)-'a']++;
			letters[s2.charAt(i)-'a']--;
		}
		for(int i = 0; i < letters.length; i++) if (letters[i] != 0) return false;
		for(int i = 1; i < s1.length(); i++){
			if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
				return true;
			}
			if(isScramble(s1.substring(0,i), s2.substring(s1.length() - i)) && 
					isScramble(s1.substring(i), s2.substring(0,s1.length()-i))){	
				return true;
			}
		}
		return false;
    }
		public static void main(String[] args) {
//		System.out.println(isScramble("abcd", "bdac"));
//		System.out.println(isScramble("a", "b"));
		System.out.println(isScramble("abc", "bca"));


	}

}
