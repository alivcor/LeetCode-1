package com.leetcode.solved;

public class RemoveDuplicatesSortedArray {

	/*
	 * Start two pointer,
	 * Pointer 1 would be updated array pointer.
	 * Pointer 2 would update pointer 1's as soon as it encounter a new element. 
	 */
	public static int removeDuplicates(int[] nums) {
		if(nums == null) return 0;
		if(nums.length == 0 || nums.length == 1)
			return nums.length;
		
		int index1 = 1;
		int index2 = 1;
		while(index2 < nums.length){
			while(index2 < nums.length && 
					nums[index2-1] == nums[index2]) index2++;
			
			if(index2 == nums.length) break;
			nums[index1++] = nums[index2++];
		}
		
		return index1;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,2,2,2,4,5,6,6,7};
		removeDuplicates(nums );

	}

}
