package com.leetcode.solved;

public class MajorityElement {
	/*
	 * Majority element is the element occurring more than half of the times.
	 * The below implementation is Moores Voting algorithm.
	 * 
	 * The idea is that if there is a majority element already present in the array.
	 * Its count would be atleast greater than count of all the element put together.
	 * 
	 * At first we will assume zeroth element as Majority. We would set the count as 1.
	 * We will traverse through the array, incrementing the count at a match and decrementing at mismatch.
	 * As soon as the count reaches zero, we will assign a majority element to the new element, and set count = 1.  
	 *
	 */
	public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int count = 1;
        int element = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == element)
                count++;
            else if(count == 0){
                element = nums[i];
                count = 1;
            }else{
                count--;    
            }
        }
        return element;
    }
}
