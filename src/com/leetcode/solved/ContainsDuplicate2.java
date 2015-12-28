package com.leetcode.solved;

import java.util.HashSet;

/*
 * Given an array of integers and an integer k.
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicate2 {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		if (k > nums.length) k = nums.length;
		
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < k; i++){
			if(set.contains(nums[i])) return true;
			set.add(nums[i]);
		}
		for(int i = k; i < nums.length; i++){
			if(set.contains(nums[i])) return true;
			set.add(nums[i]);
			set.remove(nums[i-k]);
		}
		return false;
    }

	public static void main(String[] args) {
		int a[] = {1,2,2,1};//3,4,5,6,7,8,9,10};
		System.out.println(containsNearbyDuplicate(a, 15));

	}

}
