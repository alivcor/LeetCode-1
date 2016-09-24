package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
	Map<Character, String> map = new HashMap<>();
    Set<String> chosenVal = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null) return (pattern == null && str == null);
        if(pattern.length() == 0 || str.length() == 0) return (pattern.length() == 0 && str.length() == 0);
        
        if(map.containsKey(pattern.charAt(0))){
            if(!str.startsWith(map.get(pattern.charAt(0)))) return false;
            return wordPatternMatch(pattern.substring(1), str.substring(map.get(pattern.charAt(0)).length()));
        }
        
        
        for(int i = 0; i < str.length(); i++){
            if(chosenVal.contains(str.substring(0,i+1))) continue;
            map.put(pattern.charAt(0), str.substring(0,i+1));
            chosenVal.add(str.substring(0,i+1));
            if(wordPatternMatch(pattern.substring(1), str.substring(i+1))) return true;
            map.remove(pattern.charAt(0));
            chosenVal.remove(str.substring(0,i+1));
        }
        
        return false;
    }
}
