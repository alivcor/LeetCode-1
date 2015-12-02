package com.leetcode.solved;

public class LengthLastWord {

	public static int lengthOfLastWord(String s) {
		
		s = s.trim();
		//Null or empty string
        if(s == null || s.length() == 0) return 0;
        
        
        int lastSpace = s.lastIndexOf(' ');
        //No space
        if(lastSpace == -1) return s.length();
        //Length with multiple/single last space
        return s.length() - lastSpace-1;
        
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Aman Raj"));
		System.out.println(lengthOfLastWord("Aman   Raj"));
		System.out.println(lengthOfLastWord("Ama"));
		System.out.println(lengthOfLastWord("Ama "));
		System.out.println(lengthOfLastWord("Ama  "));
		System.out.println(lengthOfLastWord("  "));
		System.out.println(lengthOfLastWord(""));

	}

}
