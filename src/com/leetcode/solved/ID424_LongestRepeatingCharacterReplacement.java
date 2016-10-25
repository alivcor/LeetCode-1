package com.leetcode.solved;

public class ID424_LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        
        int left, right, maxCount, maxLen;
        left = right = maxCount = maxLen = 0;
    
        while(right < s.length()){
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
            if(right - left + 1 - maxCount > k) charCount[s.charAt(left++) - 'A']--;
            maxLen = Math.max(right++ - left + 1, maxLen);
        }
        return maxLen;
    }

}
