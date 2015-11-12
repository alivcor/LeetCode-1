package com.leetcode.solved;


public class MoveZeros {
	
	public void moveZeroes(int[] nums) {
	        
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
