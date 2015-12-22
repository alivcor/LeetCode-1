package com.leetcode.solved;

public class MaxProdWordLength {

	private static int mapString(String s){
		int intVal = 0;
		for(int i = 0; i < s.length(); i++){
			intVal = intVal | (1<<(s.charAt(i)-'a'));
		}
		
		return intVal;
	}
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
