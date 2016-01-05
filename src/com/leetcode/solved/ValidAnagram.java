package com.leetcode.solved;

public class ValidAnagram {

	/*
	 * Two strings are Anagram when characters in one string are permutation of other.
	 * 
	 * In the solution below, we will assume the characters are ASCII.
	 * If any one of the strings in null, both should be null.
	 * If the length of two strings doesnot match. Return False.
	 * 
	 * The idea is to create a count array of integers, where each index is for a character.
	 * Increment the value of that index for one string and decrement for other.
	 * If after we have traversed both the strings, the value for each index is 0.
	 * True.
	 * Else False.
	 */
	public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return (s == null && t == null);
        
        if(s.length() != t.length()) return false;
        
        int countArray[] = new int[255];
        
        for(int i = 0; i < s.length(); i++){
            countArray[s.charAt(i)]++;
        }
        
        for(int i = 0; i < t.length(); i++){
            countArray[t.charAt(i)]--;
        }
        
        for(int i = 0; i < 255; i++){
            if(countArray[i] != 0) return false;
        }
        
        return true;
    
    }
}
