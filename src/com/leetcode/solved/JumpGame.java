package com.leetcode.solved;

import java.util.Arrays;

public class JumpGame {
	
	public static boolean canJump(int[] nums) {
		 
		 if(nums == null || nums.length == 0 || nums.length == 1)
			 return true;
		 
		 if(nums.length > 1 && nums[0] == 0)
			 return false;
		 
		 boolean data[] = new boolean[nums.length];
		 Arrays.fill(data,false);
		 
		 data[0] = true;
		 for(int i = 1; i < nums.length; i++){
			 for(int j = i-1; j >= 0; j--){
				 if(nums[j] >= (i-j) && data[j]){
					 data[i] = true;
					 break;
				 }
			 }
		 }
		 
		 return data[nums.length-1];
	 }

	public static void main(String[] args) {
		int[] nums = {1,0,1,0};
		System.out.println(canJump(nums ));

	}

}
