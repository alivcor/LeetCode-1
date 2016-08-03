package com.leetcode.premium;

public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int index = 1;
        for(int i = 1; i < nums.length; i++){
             if(nums[i] == nums[i-1]) continue;
             nums[index++] = nums[i];
        }
        int count = (index >= 2 ) ? 2 : index;
        for(int i = 2; i < index; i++){
            if((nums[i-1] - nums[i-2]) * (nums[i] - nums[i-1]) < 0) count++;
        }
        return count;
    }

}
