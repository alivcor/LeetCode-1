package com.leetcode.solved;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        char[] count = new char[256];
        for(int i = 0; i < s.length(); i++)count[s.charAt(i)]++;
        
        int countOdd = 0;
        for(int i = 0; i < count.length; i++) countOdd += count[i]%2;
        
        return countOdd <= 1;
    }

}
