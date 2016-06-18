package com.leetcode.solved;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstring {

    
    public static String minWindow(String a, String b){
		if(a == null || b == null) return "";
		if(a.length() < b.length()) return "";
		
		Map<Character, Deque<Integer>> map = new HashMap<>();
		Map<Character,Integer> setChar = new HashMap<>();
		for(int i = 0; i < b.length(); i++){
			if(!setChar.containsKey(b.charAt(i))) setChar.put(b.charAt(i), 0);
			setChar.put(b.charAt(i),setChar.get(b.charAt(i)) + 1);
		}
		
		String minString = "";
		int count = 0;
		for(int i = 0; i < a.length(); i++){
			if(setChar.containsKey(a.charAt(i))){
				if(!map.containsKey(a.charAt(i))) map.put(a.charAt(i), new LinkedList<>());
				if(map.get(a.charAt(i)).size() == setChar.get(a.charAt(i))){
					count--;
					map.get(a.charAt(i)).removeFirst();
				}
				map.get(a.charAt(i)).add(i);
				count ++;
				if(count >= b.length()){
					String currWindow = findMinMax(map, a);
					if(("").equals(minString) || minString.length() > currWindow.length()) minString = currWindow;
				}
			}
		}
		
		return minString;
	}
	private static String findMinMax(Map<Character, Deque<Integer>> map, String a){
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		
		for(Deque<Integer> val : map.values()){
			minVal = (minVal > val.getFirst()) ? val.getFirst() : minVal;
			maxVal = (maxVal < val.getLast()) ? val.getLast() : maxVal;
		}
		
		return a.substring(minVal, maxVal + 1);
		
	}


}
