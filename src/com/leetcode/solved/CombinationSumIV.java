package com.leetcode.solved;

import java.util.Arrays;

public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int result[] = new int[target + 1];
        for(int i = 1; i <= target; i++){
            for(int value : nums){
                if(value > i) break;
                if(value == i) result[i]++;
                else result[i] += result[i-value];
            }
        }
        return result[target];
    }
}
