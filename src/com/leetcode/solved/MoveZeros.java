package com.leetcode.solved;


public class MoveZeros {
	/*
	 * Move all zeros to end of array maintaining relative order of elements.
	 * 
	 *  Maintain two indices.
	 *  Move indices and as soon as we encounter a zero, overwrite.
	 *  Write rest of the array as zero.
	 *
	 */
	public void moveZeroes(int[] nums) {
	        if(nums == null || nums.length == 0) return;
	        int index = 0;
	        int indexNZ = 0;
	        
	        while(indexNZ < nums.length){
	            if(nums[indexNZ] != 0){
	                nums[index++] = nums[indexNZ];
	            }
	            indexNZ++;
	            
	        }
	        while(index < nums.length) nums[index++] = 0;
	    }

}
