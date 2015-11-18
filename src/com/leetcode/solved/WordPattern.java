package com.leetcode.solved;

import java.util.HashMap;

public class WordPattern {

	/*
	 * Create a Key Value pair, with key as the letters in Pattern, 
	 * follow a similar pattern in string, if it breaks, return false,
	 * if not return true at the end of the sentence.
	 */
	public static boolean wordPattern(String pattern, String str) {
    
		HashMap<Character, String> wordMap = new HashMap<>();
		String[] arrayWords = str.split(" ");
		
		if(arrayWords.length != pattern.length()) return false;
		for(int i = 0; i < pattern.length(); i++){
			if(wordMap.containsKey(pattern.charAt(i))){
				if(!arrayWords[i].equalsIgnoreCase(wordMap.get(pattern.charAt(i)))){
					return false;
				}
			}else if(wordMap.containsValue(arrayWords[i])){
				return false;
			}else{
				wordMap.put(pattern.charAt(i), arrayWords[i]);
			}
		}
		return true;
    }
	public static void main(String[] args) {
		System.out.println(wordPattern("abab", "tom tom tom tom"));

	}

}
