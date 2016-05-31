package com.leetcode.solved;

import java.util.Arrays;

public class WiggleSortII {

	public static void wiggleSort(int[] nums) {
		if(nums == null || nums.length <= 1) return;
		Arrays.sort(nums);
		int[] result = new int[nums.length];
		int i = (nums.length%2 == 0) ? nums.length/2 -1 : nums.length/2;
		int j = nums.length -1;
		int index = 0;
		while(index < nums.length){
			if(i >= 0)result[index++] = nums[i--];
			if(index == nums.length)break;
			result[index++] = nums[j--];
		}
		
		System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
