package com.leetcode.solved;

public class IncreasingTripletSubsequence {
	
	public static boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3) return false;
		int leftSmall[] = new int[nums.length];
		int rightLarge[] = new int[nums.length];
		
		leftSmall[0] = nums[0];
		rightLarge[nums.length - 1] = nums[nums.length - 1];
		
		for(int i = 1; i < nums.length; i++){
			leftSmall[i] = (leftSmall[i-1] < nums[i]) ? leftSmall[i-1] : nums[i];
		}
		for(int i = nums.length - 2; i >= 0; i--)
			rightLarge[i] = (rightLarge[i+1] > nums[i]) ? rightLarge[i+1] : nums[i];
		
		for(int i = 1; i < nums.length; i++){
			if(leftSmall[i] < nums[i] && nums[i] < rightLarge[i]) return true;
		}
		return false;
    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(increasingTriplet(nums ));

	}

}
