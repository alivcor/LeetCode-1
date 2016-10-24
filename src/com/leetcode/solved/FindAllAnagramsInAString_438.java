package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString_438 {
	private boolean areAnagram(int[] A, int[] B){
        for(int i = 0; i < A.length; i++) if(A[i] != B[i]) return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) return result;
        
        int charCount[] = new int[26];
        int charS[] = new int[26];
        for(int i = 0; i < p.length(); i++){
            charCount[p.charAt(i) - 'a']++;
            charS[s.charAt(i) - 'a']++;
        } 
        if(areAnagram(charCount, charS)) result.add(0);
        int left = 0;
        int right = p.length();
        while(right < s.length()){
            charS[s.charAt(left++) - 'a']--;
            charS[s.charAt(right) - 'a']++;
            if(areAnagram(charCount, charS)) result.add(left);
            right++;
        }
        
        return result;
    }

}
