package com.leetcode.solved;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	/*
	 * 1. Hash all values.
	 * 2. Now from first element check if it is part of a sequence both side.
	 * 3. To keep the algorithm in Linear complexity keep deleting the values from the hash once considered.
	 */
	public static int longestConsecutive(int[] nums) {
       
		HashSet<Integer> set = new HashSet<>();
		int countMax = 0;
		int currentMax = 0;
		for(int element : nums)
			set.add(element);
		
		for(int i = 0; i < nums.length; i++){
			if(set.contains(nums[i])){
				currentMax = count(nums[i], set);
				if(countMax < currentMax){
					countMax  = currentMax;
				}
				currentMax = 0;
			}
		}
		return countMax;
    }

	private static int count(int i,HashSet<Integer> set) {
		int count = 0;

		int val = i-1;
		while(set.contains(val)){
			set.remove(val);
			val--;
			count++;
		}
		while(set.contains(i)){
			set.remove(val);
			i++;
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		int array[] = {-1,1,0};//{100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(array));
		

	}

}
