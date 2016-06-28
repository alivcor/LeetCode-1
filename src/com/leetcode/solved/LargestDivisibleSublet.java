package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSublet {
	public static List<Integer>  largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) return Collections.emptyList();
        Arrays.sort(nums);
        
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
        	List<Integer> temp = new ArrayList<>();
        	temp.add(nums[i]);
        	for(int j = i - 1; j >= 0; j--){
        		if(temp.get(temp.size() - 1)%nums[j] == 0) temp.add(nums[j]);
        	}
        	
        	if(result.size() < temp.size()) result = temp;
        }
        Collections.sort(result);
        return result;
        
    }

}
