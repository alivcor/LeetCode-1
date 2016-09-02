package com.leetcode.solved;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = Integer.MIN_VALUE;
        int maxSum = sum;
        for(int i = 0; i < nums.length; i++){
            if(sum < 0) sum = 0;
            sum += nums[i];
            maxSum = Integer.max(maxSum,sum);
        }
        return maxSum;
        
    }

}
