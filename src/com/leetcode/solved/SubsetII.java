package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetII {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return listSet;
        Arrays.sort(nums);
        
        int[] curr = new int[nums.length];
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        subset(nums, 0, 0, set, curr);
        listSet = new ArrayList<>(set);
        return listSet;
    }
	
	/** Calculation of set by inclusion exclusion principle.
	 * Either that element will belong to the set or it won't
	 * Recurse for both scenarios.
	 * 
	 * Add to SET when reached to end of list.
	 * Set will make sure that the subsets are not repeated.
	 * @param nums
	 * @param index
	 * @param currIndex
	 * @param subsets
	 * @param curr
	 */
	private static void subset(int[] nums, int index, int curIndex,
			Set<List<Integer>> subsets,
			int[] curr){
		
		if(index == nums.length){
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < curIndex; i++){
				temp.add(curr[i]);
			}
			subsets.add(temp);
			return;
		}
		
		subset(nums, index + 1, curIndex,subsets, curr);
		curr[curIndex] = nums[index];
		subset(nums, index + 1, curIndex + 1, subsets, curr);
		
	}
	public static void main(String[] args) {
		int array[] = {5,4,5,3,4};
		System.out.println(subsetsWithDup(array));

	}

}
