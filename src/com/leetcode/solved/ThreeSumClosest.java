package com.leetcode.solved;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int  threeSumClosest(int[] nums, int target) {
		if(nums == null) return 0;
		if(nums.length < 3) return Arrays.stream(nums).sum();
		int closest = nums[0] + nums[1] + nums[2];
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++){
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k){
				int currSum = nums[i] + nums[j] + nums[k];
				if(Math.abs(target - currSum) < Math.abs(closest - target)) closest = currSum;
				if(currSum == target) return currSum;
				else if(currSum < target) j++;
				else k--;
			}
		}
	    return closest;
	}
	
	public static void main(String[] args) {
		int nums[] = {0,2,1,-3};
		System.out.println(threeSumClosest(nums, 1));

	}

}
