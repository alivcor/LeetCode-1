package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDifferentCharacters {

	/*
    Create a map of char, index of char.
    Two pointer traverse from left to right, keep adding chars in map, such that map contains the latest index of the char
    whenever the map is full and a new char appears, move the left pointer until the point we can remove a char.
    A char can only be removed if the latest occurance index of char is same that is present in map
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        int maxLength = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.size() < k || map.containsKey(s.charAt(i))){
                //the map can accommdate more characters or it already contains taht char.
                 map.put(s.charAt(i),i);
                 maxLength = Integer.max(maxLength,i - left + 1);
            }else{
                //map doesn't contain the same char, so remove a char
                while(left < i && map.size() == k){
                    // System.out.println(map);
                    // System.out.println(s.charAt(left));
                    if(map.get(s.charAt(left)) == left) map.remove(s.charAt(left));
                    left++;
                }
                map.put(s.charAt(i),i);
            }
        }
        
        return Integer.max(maxLength,s.length() - left);
        
        
    }
}
