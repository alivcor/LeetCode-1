package com.leetcode.solved;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int count[] = new int[256];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        
        int maxCount = 0;
        int addOdd = 0;
        for(int i = 0; i < count.length; i++){
            maxCount += 2*(count[i]/2);
            addOdd = Integer.max(addOdd, count[i]%2);
        }
        
        return maxCount + addOdd;
        
    }

}
