package com.leetcode.solved;

import java.util.HashMap;

public class ValidAnagram {

	/*
	 * Two strings are Anagram when characters in one string are permutation of other.
	 * 
	 * In the solution below, we will assume the characters are ASCII.
	 * If we are sure that all characters are lower case/upper case and alphabets,
	 * we can decrement each char by 'A' or 'a' and keep an array of size 26.
	 * 
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
	/*
	 * In the case where the characters are not ASCII but Unicode
	 * It would not be a good idea to create such a long count array.
	 * Better idea would be to use a HashMap to store the Characters.
	 * 
	 * Same above logic applied.
	 */
	public boolean isAnagramUnicode(String s, String t){
		if(s == null || t == null) return (s == null && t == null);
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> countChars = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
        	if(countChars.get(s.charAt(i)) == null)
        		countChars.put(s.charAt(i), 0);
        	countChars.put(s.charAt(i), countChars.get(s.charAt(i)) + 1);
        	
        }
        
        for(int i = 0; i < t.length(); i++){
        	if(countChars.get(t.charAt(i)) == null)
        		return false;
        	countChars.put(t.charAt(i), countChars.get(t.charAt(i)) - 1);
        	if(countChars.get(t.charAt(i)) < 0) return false;
        }
        
        
        return true;
	}
}
