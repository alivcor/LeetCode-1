package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
		if(nums == null) return subset;
		Arrays.sort(nums);
		int[] curr = new int[nums.length];
		subList(nums, 0,0, subset, curr);
		return subset;
    }
	
	/** Calculation of set by inclusion exclusion principle.
	 * Either that element will belong to the set or it won't
	 * Recurse for both scenarios.
	 * 
	 * Return when reached to end of list.
	 * @param nums
	 * @param index
	 * @param currIndex
	 * @param subsets
	 * @param curr
	 */
	private static void subList(int[] nums, int index, int currIndex, 
			List<List<Integer>> subsets, int[] curr){
		if(index == nums.length){
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < currIndex; i++){
				temp.add(curr[i]);
			}
			subsets.add(temp);
			return;
		}
		
		subList(nums, index + 1,currIndex, subsets, curr);
		curr[currIndex] = nums[index];
		subList(nums, index + 1, currIndex + 1,subsets, curr);
		
		return;
	}
	public static void main(String[] args) {
		int array[] = {1,2,3};
		System.out.println(subsets(array));

	}

}
