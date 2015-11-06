package com.leetcode.solved;

public class LongestCommonPrefix {
	/*
	 * Assume the first element as Prefix.
	 * Now for every consecutive element, find the prefix of this element with Prefix.
	 * Store the new Prefix. Keep doing this till the end of array
	 * Return the prefix.
	 */
	public static String longestCommonPrefix(String[] strs) {
        
		if(strs == null || strs.length == 0) return "";
		
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++){
			if(prefix.length() > strs[i].length()){
				prefix = prefix.substring(0,strs[i].length());
			}
			for(int j = 0; j < prefix.length(); j++){
				if(strs[i].charAt(j) != prefix.charAt(j)){
					prefix = prefix.substring(0,j);
					break;
				}
			}
		}
		
		
		return prefix;
    }

	public static void main(String[] args) {
		String arrayStr[] = {"abcde","abce","abcf","ab"};
		System.out.println(longestCommonPrefix(arrayStr));

	}

}
