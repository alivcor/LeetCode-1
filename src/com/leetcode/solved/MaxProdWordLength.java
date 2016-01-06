package com.leetcode.solved;

public class MaxProdWordLength {
	
	/*
	 * The function which maps each String to an integer.
	 * This function would set few bits corrosponding to the respective characters.
	 * 
	 * This would help us determine if two strings have distinct set of characters in O(1) time.
	 */
	private static int mapString(String s){
		int intVal = 0;
		for(int i = 0; i < s.length(); i++){
			intVal = intVal | (1<<(s.charAt(i)-'a'));
		}
		
		return intVal;
	}
	/*
	 * Create Integer value for each of the characters.
	 * Now traverse the array of strings, comparing each word with every other word.
	 * If the characters are distinct and the product of these two form maxProd.
	 * Replace.
	 * 
	 * Return maxProd
	 */
	public static int maxProduct(String[] words) {
        int[] valString = new int[words.length];
        
        int maxProd = 0;
        for (int i = 0; i < words.length; i++){
        	valString[i] = mapString(words[i]);
        }
        for(int i = 0; i < words.length - 1; i++){
        	for(int j = i+1; j < words.length; j++){
        		if((valString[i]&valString[j]) == 0 &&
        				(words[i].length()*words[j].length()) > maxProd)
        			maxProd = words[i].length()*words[j].length();
        	}
        }
        
        return maxProd;
    }
	public static void main(String[] args) {
		String[] words = {"abc","cde"};
		System.out.println(maxProduct(words));

	}

}
