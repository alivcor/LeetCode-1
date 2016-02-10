package com.leetcode.solved;

public class HouserRobber {

	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Integer.max(nums[0],nums[1]);
        nums[2] = nums[2] + nums[0];
        for(int i = 3; i < nums.length; i++)
            nums[i] = nums[i] + Integer.max(nums[i-2], nums[i-3]);
        
        return Integer.max(nums[nums.length-1],nums[nums.length-2]);
        
    }
}
