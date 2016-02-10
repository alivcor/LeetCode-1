package com.leetcode.solved;

public class HouseRobberII {
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Integer.max(nums[0], nums[1]);
        int newA[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) newA[i] = nums[i];
        return Integer.max(rob(newA,1,nums.length-1),rob(nums,0,nums.length-2));
    }
    
    public int rob(int[] nums, int start, int end) {
        
        if(start + 1 == end)  return Integer.max(nums[start], nums[start + 1]);
        nums[start + 2] = nums[start + 2] + nums[start];
        for(int i = start + 3; i <= end; i++)
            nums[i] = nums[i] + Integer.max(nums[i-2], nums[i-3]);
        
        return Integer.max(nums[end],nums[end-1]);
        
    }

}
