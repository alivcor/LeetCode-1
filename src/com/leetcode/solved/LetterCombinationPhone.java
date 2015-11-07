package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationPhone {
	
	static HashMap<Integer, List<String>> mapChar;
	
	/*
	 * Method to initialize a map of characters present for each integer.
	 */
	public static List<String> returnList(int n){
		
		if(mapChar != null){
			return mapChar.get(n);
		}
		HashMap<Integer, List<String>> mapChar = new HashMap<>();
		char c = 'a';
		
		for(int i = 2; i <=9; i++){
			List<String> charList = new ArrayList<>();
			int countChar = 3;
			if(i > 6 && i != 8){
				countChar = 4;
			}
			for(int j = 0; j < countChar; j++){
				charList.add(c++ + "");
			}
			mapChar.put(i, charList);
		}
		
		return mapChar.get(n);
	}
	
	/*
	 * Recursive function to find the list.
	 */
	public static List<String> letterCombinations(String digits) {
		
		List<String> listStrings = new ArrayList<String>();
		if(digits.length() == 0) return listStrings;
		if(digits.length() == 1) return returnList(digits.charAt(0) - '0');
		
		List<String> listChars = returnList(digits.charAt(0)-'0');
		for(String c : listChars){
			List<String> letterCombinations = letterCombinations(digits.substring(1));
			for(String st : letterCombinations){
				listStrings.add(c+st);
			}
		}
		
		return listStrings;
    }
	

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));

	}

}
