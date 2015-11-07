package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permute(nums, 0, list );
     
		return list;
    }
	
	public static void swap(int i, int j, int[] array){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static List<Integer> toList(int[] nums){
		
		List<Integer> tempL = new ArrayList<>();
		for(int elem : nums){
			tempL.add(elem);
		}
		
		return tempL;
	}
	
	/*
	 * 1. Swap with second onwards, recurse, replace back
	 */
	public  static void permute(int[] nums, int index,List<List<Integer>> list){
		
		if(index == nums.length - 1){
			list.add(toList(nums));
			return ;
		}
		
		for(int i = index; i < nums.length; i++){
			swap(index, i, nums);
			permute(nums,index+1,list);
			swap(index,i,nums);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(permute(nums));

	}

}
