package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	public static List<String> wordBreak(String s, Set<String> wordDict){
		if(s == null || s.length() == 0) return Collections.emptyList();
		return wordBreak(s, wordDict, new HashMap<String,List<String>>());
	}
	
	private static List<String> wordBreak(String s,Set<String> wordDict, Map<String,List<String>> cacheMap){
		if(cacheMap.containsKey(s)) return cacheMap.get(s);
		List<String> result = new ArrayList<>();
		if(s.length() == 0){
			result.add("");
			return result;
		}
		
		for(String word : wordDict){
			if(s.startsWith(word)){
				List<String> rest = wordBreak(s.substring(word.length()), wordDict, cacheMap);
				for(String restVal : rest){
					result.add(word + ((restVal.length() == 0) ? "" : " ") + restVal);
				}
			}
		}
		cacheMap.put(s,result);
		return result;
	}

}
