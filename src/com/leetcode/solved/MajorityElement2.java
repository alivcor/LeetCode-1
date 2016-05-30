package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElement2 {
	
	private static void increment(int[] count, Integer[] value, int item){
		for(int i = 0; i < value.length; i++){
			if(value[i] != null && value[i] == item) count[i]++;
		}
	}
	
	private static void decrementAll(int[] count,Integer[] value, Set<Integer> setInt){
		for(int i = 0; i < count.length; i++){
			count[i]--;
			if(count[i] == 0){
				setInt.remove(value[i]);
			}
		}
	}
	private static void insert(int[] count, Integer[] value, int item){
		for(int i = 0; i < value.length; i++){
			if(count[i] == 0){
				value[i] = item;
				count[i] = 1;
				
				return;
			}
		}
	}
	public static List<Integer> majorityElement(int[] nums) {
		if(nums == null) return Collections.emptyList();
		
		Integer[] value = new Integer[3];
		int[] count = new int[3];
		Set<Integer> setInt = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++){
			if(setInt.contains(nums[i])) increment(count, value, nums[i]); 
			else if(setInt.size() < 3){
				setInt.add(nums[i]);
				insert(count, value, nums[i]);
			}
			else decrementAll(count, value, setInt);
		}
		for(int i = 0; i < 3; i++) count[i] = 0;
		for(int i = 0; i < nums.length; i++) if(setInt.contains(nums[i])) increment(count, value, nums[i]);
		
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < count.length; i++) {
			if(count[i] > nums.length/3) result.add(value[i]);
		}
		
		return result;
    }

	public static void main(String[] args) {
		int nums[] = {1};
		System.out.println(majorityElement(nums));

	}

}
