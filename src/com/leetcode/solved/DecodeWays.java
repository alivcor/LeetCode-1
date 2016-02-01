package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	static Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
	public static int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		int result = numDecode(s, 0);
		dp = new HashMap<>();
        return result;
    }
	
	private static int numDecode(String s, int index){
		if(dp.get(index) != null) return dp.get(index);
		if(s.length() > index && s.charAt(index) == '0') return 0;
		if(s.length() == index) return 1;
		int oneL = numDecode(s,index + 1);
		int twoL = 0;
		if(s.length() > index + 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26){
			twoL = numDecode(s, index + 2);
		}
		dp.put(index, oneL + twoL);
		return oneL + twoL;
	}
	
	
	public static void main(String[] args) {
		System.out.println(numDecodings("17"));

	}

}
