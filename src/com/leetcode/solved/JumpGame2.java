package com.leetcode.solved;

public class JumpGame2 {

	public static int jump(int[] nums){
		if(nums == null || nums.length <= 1) return 0;
		
		int maxRange = nums[0];
		int newRange = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++){
			if(maxRange < i){
				maxRange = newRange;
				count++;
			}
			if(newRange < i + nums[i]){
				newRange = i + nums[i];
			}
			if(maxRange >= nums.length) return count;
		}
		
		return count;
	}
}
