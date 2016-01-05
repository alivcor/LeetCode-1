package com.leetcode.solved;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
	/*
	 * Return true if there is at least one duplicate in the entire array.
	 * 
	 * If the array is null/ length 0 or 1, it cannot contain any duplicates.
	 * Create a set of Integers, traverse through the array, 
	 * If the current element is already present, return true.
	 * If we have traversed through the complete array and none of the elements repeat.
	 * Return false.
	 */
	public boolean containsDuplicate(int[] nums) {
        
        if(nums == null || nums.length == 0 || nums.length == 1) return false;
        
        HashSet<Integer> setInt = new HashSet<Integer>();
        for(int i : nums){
            if(setInt.contains(i))
                return true;
            setInt.add(i);
        }
        
        return false;
    }
	/*
	 * If we add all the elements in the array to a set, 
	 * and if the size of the array is equal to the size of the set: All Unique
	 * Else atleast one duplicate.
	 * 
	 */
	public boolean containsDuplicateOneLiner(int nums[]){
		return !(nums.length == (new HashSet<>(Arrays.asList(nums))).size());
	}
}
