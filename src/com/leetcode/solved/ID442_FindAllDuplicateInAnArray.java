package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class ID442_FindAllDuplicateInAnArray {

	/*
    1. Create a set and check O(N) time O(N) space
    2. Sort the array. O(NlogN) time O(1)
    */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null) return result;
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] < 0) result.add(Math.abs(nums[i]));
            else nums[Math.abs(nums[i]) - 1] *= -1;
        }
        
        return result;
    }
	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));

	}

}
