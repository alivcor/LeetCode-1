package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permuteUnique(nums,0, result);
		return result;
    }
	
	private static final void swap(int array[], int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void permuteUnique(int[] nums, int curIndex, List<List<Integer>> result) {
        if(curIndex == nums.length) {
        	List<Integer> temp = new ArrayList<>();
        	for(int i : nums) temp.add(i);
        	result.add(temp);
        	return;
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for(int i = curIndex; i < nums.length; i++){
        	if(!visited.add(nums[i])) continue;
        	swap(nums, curIndex, i);
    		permuteUnique(nums,curIndex + 1, result);
        	swap(nums, curIndex, i);
        }
    }

}
