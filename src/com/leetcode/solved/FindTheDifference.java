package com.leetcode.solved;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
        int xor = t.charAt(t.length() - 1);
        for(int i = 0; i < s.length(); i++) xor = xor^s.charAt(i)^t.charAt(i);
        return (char)xor;
    }

}
