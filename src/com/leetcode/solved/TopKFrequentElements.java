package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int value : nums){
        	if(!countMap.containsKey(value)) countMap.put(value, 0);
        	countMap.put(value, countMap.get(value) + 1);
        }
        
        List<Integer> result = new ArrayList<Integer>(countMap.keySet());
        result.sort((a,b) -> (countMap.get(b)).compareTo(countMap.get(a)));
        return (k >= countMap.size()) ? result : result.subList(0, k);
	}

	public static void main(String[] args){
		int nums[] = {3,0,1,0};
		System.out.println(topKFrequent(nums, 1));
	}
	
	
}
