package com.leetcode.solved;

public class PalindromePartitioningII {
	public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;
        
        int dpArray[] = new int[s.length()+1];
        for(int i = 0; i < dpArray.length; i++) dpArray[i] = i-1;
        for(int i = 0; i < s.length(); i++){
            //i is the center.
            for(int j = 0; i-j >= 0 && i + j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++)
                dpArray[i+j+1] = Integer.min(dpArray[i+j+1], 1 + dpArray[i-j]);
                
            for(int j = 1; i-j+1 >= 0 && i + j < s.length() && s.charAt(i-j+1) == s.charAt(i+j); j++)
                dpArray[i+j+1] = Integer.min(dpArray[i+j+1], 1 + dpArray[i-j+1]);
        }
        
        return dpArray[s.length()];
    }

}
