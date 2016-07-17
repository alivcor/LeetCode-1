package com.leetcode.solved;


public class RemoveDuplicateLetters {

	public static String removeDuplicateLetters(String s) {
		int count[] = new int[26];
		for(int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
		int minValPos = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) < s.charAt(minValPos)) minValPos = i;
			if(--count[s.charAt(i) - 'a'] == 0)break;
		}
		return (s.isEmpty()) ? "" : s.charAt(minValPos) + removeDuplicateLetters(s.substring(minValPos+1).replaceAll("" + s.charAt(minValPos), ""));
    }
	
	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}

}
