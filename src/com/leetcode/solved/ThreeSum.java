package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
        	if(i > 0 && nums[i] == nums[i-1]) continue;
        	int j = i + 1;
        	int k = nums.length-1;
        	while(j < k){
        		int currSum = nums[i] + nums[j] + nums[k];
				if(currSum == 0){
        			result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			while(j < k && nums[j] == nums[j+1])j++;
        			while(j < k && nums[k] == nums[k-1])k--;
        			j++;
        			k--;
        		}else if(currSum < 0) j++;
        		else k--;
        	}
        }
        return result;
    }
}
