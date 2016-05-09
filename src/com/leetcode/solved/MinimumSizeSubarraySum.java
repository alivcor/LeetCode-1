package com.leetcode.solved;

public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return (nums[0] == s) ? 1 : 0;
		
		int i = 0;
		int j = 0;
		
		int currentSum = nums[0];
		int minL = Integer.MAX_VALUE;
		while(i <= j && j < nums.length){
			if(currentSum < s && j < nums.length){
				j++;
				if(j < nums.length) currentSum += nums[j];
			}
			else if(currentSum >= s){
				if(minL > (j-i)) minL = j-i;
				currentSum -= nums[i++];
			}
		}
		return (minL == Integer.MAX_VALUE) ? 0 : minL + 1 ;
    }
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5};//{2,3,1,2,4,3};
		System.out.println(minSubArrayLen(11, array));

	}

}
