package com.leetcode.solved;

import java.util.HashMap;

public class TwoSum {

	/*
	 * Every number might be one of the two numbers.
	 * Create a HashaMap with key as the value present in the array and value as the index.
	 * For every number if target - num[i] is present in hashmap: we have found the solution,
	 * else insert the value, index pair into HashMap.
	 */
	public int[] twoSum(int[] nums, int target) {
		
        HashMap<Integer,Integer> mapInt = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
        	if(mapInt.containsKey(target - nums[i])){
        		int result[] = {mapInt.get(target-nums[i]),i+1};
        		return result;
        	}
        	
        	mapInt.put(nums[i], i+1);
        }
        
        int result[] = {-1,-1};
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
