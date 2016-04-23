package com.leetcode.solved;

import java.util.Arrays;

public class NextPermutation {
	
	public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        for(int i = nums.length - 2; i >= 0; i--){
        	if(nums[i] < nums[i+1]){
        		int j = nums.length - 1;
        		while(nums[i] >= nums[j]) j--;
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        		Arrays.sort(nums, i+1, nums.length);
        		return;
        	}
        }
        Arrays.sort(nums);
        return;
    }

	public static void main(String[] args) {
		int[] nums = {1,5,1};
		nextPermutation(nums);
		Arrays.stream(nums).forEach(a ->System.out.println(a));

	}

}
