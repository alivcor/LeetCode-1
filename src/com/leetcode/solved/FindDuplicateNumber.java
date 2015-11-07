package com.leetcode.solved;

import java.util.Arrays;

public class FindDuplicateNumber {
	
	/*
	 * Sort the array
	 * Do a linear search to find the duplicate element.
	 */
	public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
        	if(nums[i-1] == nums[i])
        		return nums[i];
        }
        
        return -1;
    }
	public static void main(String[] args) {
		int[] nums = {1,2,4,4,4};
		System.out.println(findDuplicate(nums ));

	}

}
