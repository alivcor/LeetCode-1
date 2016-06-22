package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	
	public static List<Integer> findSubstring(String text, String[] list){
		if(text == null || text.length() == 0 || list == null || list.length == 0) return Collections.emptyList();
		
		Map<String,Integer> countMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		int wordLength = list[0].length();
		for(String word : list)
			countMap.put(word, (countMap.containsKey(word)) ? countMap.get(word) + 1 : 1);
		
		for(int i = 0; i <= text.length() - wordLength*list.length; i++){
			Map<String,Integer> copy = new HashMap<>(countMap);
			for(int j = i; j < i + wordLength*list.length; j+=wordLength){
				String currWord = text.substring(j,j+wordLength);
				if(copy.containsKey(currWord)){
					if(copy.get(currWord) == 1) copy.remove(currWord);
					else copy.put(currWord, copy.get(currWord) - 1);
					if(copy.size() == 0) result.add(j - wordLength*(list.length-1));
				}else break;
			}
		}
		
		return result;
	}

}
