package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	
	public static boolean wordBreak(String s, Set<String> wordDict) {
		if(wordDict == null || wordDict.size() == 0 || s == null) return false;
		
		Map<String,Boolean> dpMap = new HashMap<String, Boolean>();
		for(String word : wordDict) dpMap.put(word, true);
        return wordBreak(s, dpMap);
    }
	
	private static boolean wordBreak(String s, Map<String,Boolean> dpMap){
		if(s == null || s.length() == 0) return true;
		if(dpMap.containsKey(s)) return dpMap.get(s);
		boolean contains = false;
		Set<String> keySet = new HashSet<>(); 
		keySet.addAll(dpMap.keySet());
		for(String key : keySet){
			if(!dpMap.get(key) || key.length() > s.length()) continue;
			if(s.startsWith(key) && wordBreak(s.substring(key.length()), dpMap)){
				contains = true;
				break;
			}
		}
		dpMap.put(s, contains);
		return dpMap.get(s);
	}
	public static void main(String[] args) {
		
		String elements[] = { "car","ca","rs"};
	    Set set = new HashSet(Arrays.asList(elements));
	    System.out.println(wordBreak("cars", set));
	}

}
