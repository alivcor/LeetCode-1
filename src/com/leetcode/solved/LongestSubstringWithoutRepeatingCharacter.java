package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
	public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int prev = 0;
        int current = 0;
        int maxL = 0;
        while(current < s.length()){
            if(map.containsKey(s.charAt(current))){
              while(prev <= map.get(s.charAt(current))){
                  map.remove(map.get(s.charAt(prev++)));
              }  
            } 
            map.put(s.charAt(current),current);
            maxL = Integer.max(maxL,current - prev + 1);
            current++;
        }
        return maxL;
    }
}
