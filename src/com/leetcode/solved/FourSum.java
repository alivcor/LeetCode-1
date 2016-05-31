package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

	
	public static List<List<Integer>> fourSum(int[] nums,int target) {
        if(nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int t = 0; t < nums.length-2; t++){
        	if(t > 0 && nums[t] == nums[t-1]) continue;
	        for(int i = t+1; i < nums.length - 2; i++){
	        	if(i > t + 1 && nums[i] == nums[i-1]) continue;
	        	int j = i + 1;
	        	int k = nums.length-1;
	        	while(j < k){
	        		int currSum = nums[t] + nums[i] + nums[j] + nums[k];
					if(currSum == target){
	        			result.add(Arrays.asList(nums[t],nums[i],nums[j],nums[k]));
	        			while(j < k && nums[j] == nums[j+1])j++;
	        			while(j < k && nums[k] == nums[k-1])k--;
	        			j++;
	        			k--;
	        		}else if(currSum < target) j++;
	        		else k--;
	        	}
	        }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,0,0,0,0,0,0};//{1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(nums, 0));

	}

}
