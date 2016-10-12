package com.leetcode.solved;

public class PartitionEqualSubsetSum {
	public static boolean canPartition1(int[] nums) {
		if(nums == null || nums.length == 0) return true;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) sum += nums[i];
		if(sum%2 == 1) return false;
		return foo(nums, 0, sum/2);
    }
	
	public static boolean foo(int nums[], int index, int target){
		if(target == 0) return true;
		if(target < 0 || index == nums.length) return false;
		return foo(nums, index+1, target - nums[index]) || foo(nums, index + 1, target); 
	}

	public static boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0) return true;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) sum += nums[i];
		if(sum%2 == 1) return false;
		boolean dpArray[] = new boolean[sum/2 + 1];
		dpArray[0] = true;
		for(int i = 0; i < nums.length; i++){
			for(int j = sum/2; j >= nums[i]; j--){
				dpArray[j] |= dpArray[j - nums[i]];
			}
		}
		return dpArray[sum/2];
    }
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[]{1,5,2}));

	}

}
