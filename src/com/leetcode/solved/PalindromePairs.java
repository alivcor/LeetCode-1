package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class PalindromePairs {

	private static boolean isPalindrome(String word){
		if(word == null || word.length() <= 1) return true;
		int index = 0;
		while(index < (word.length()-index-1)){
			if(word.charAt(index) != word.charAt(word.length() - index - 1)) return false;
			index++;
		}
		return true;
	} 
	
	private static String reverse(String word){
		return new StringBuilder(word).reverse().toString();
	}
	public static List<List<Integer>> palindromePairs(String[] words) {
		if(words == null || words.length < 2) return Collections.emptyList();
		
		List<List<Integer>> result = new ArrayList<>();
		Map<String, Integer> indexMap = new HashMap<String,Integer>();
		IntStream.range(0, words.length).forEach(i -> indexMap.put(words[i], i));
		
		for(int i = 0; i < words.length; i++){
			for(int k = 0; k <= words[i].length(); k++){
				String formar = words[i].substring(0,k); 
				String later = words[i].substring(k);
				String reverseLater = reverse(later);
				if(isPalindrome(formar) && indexMap.containsKey(reverseLater) && indexMap.get(reverseLater) != i){
					result.add(Arrays.asList(indexMap.get(reverseLater),i));
				}
				String reverseFormer = reverse(formar);
				if(isPalindrome(later) && indexMap.containsKey(reverseFormer) &&
						indexMap.get(reverseFormer) != i && later.length() != 0){
					result.add(Arrays.asList(i,indexMap.get(reverseFormer)));
				}
			}
		}
		return result;
    }
	
	public static void main(String args[]){
		String[] words = {"a",""};//{"abcd", "dcba", "lls", "s", "sssll"};
		System.out.println(palindromePairs(words));
	}

}
