package com.leetcode.solved;

public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int maxHerePrevious = nums[0];
		int minHerePrevious = nums[0];
		int maxSoFar = nums[0];
		
		int minHere, maxHere;
		
		for(int i = 1; i < nums.length; i++){
			maxHere = Integer.max(Integer.max(nums[i]*maxHerePrevious, nums[i]*minHerePrevious),nums[i]);
			minHere = Integer.min(Integer.min(nums[i]*maxHerePrevious, nums[i]*minHerePrevious),nums[i]);
			minHerePrevious = minHere;
			maxHerePrevious = maxHere;
			maxSoFar = Integer.max(maxSoFar, maxHerePrevious);
		}
		return  maxSoFar;
    }

}
