package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumberAfterSelf {
	private static class BSTFreq{
		int value;
		int countSmallLeft;
		int freq;
		BSTFreq left;
		BSTFreq right;
		public BSTFreq(int value) {
			this.value = value;
			this.countSmallLeft = 0;
			this.freq = 1;
		}
		@Override
		public String toString() {
			return "BSTFreq [value=" + value + ", countSmall=" + countSmallLeft + ", freq=" + freq + ", left=" + left
					+ ", right=" + right + "]";
		}
		
	}
	
	private static BSTFreq addValue(BSTFreq root, int value){
		if(root == null) return new BSTFreq(value);
		if(root.value == value){
			root.freq++;
		}
		else if(root.value < value) {
			root.right = addValue(root.right, value);
		}else{
			root.left = addValue(root.left, value);
			root.countSmallLeft++;
		}
		 return root;
	}
	private static int search(BSTFreq root, int value){
		if(root == null) return 0;
		if(root.value == value) return root.countSmallLeft;
		
		if(root.value < value)  return root.freq + root.countSmallLeft + search(root.right, value);
		return search(root.left, value);
	}
	
	public static List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return Collections.emptyList() ;
        
		List<Integer> result = new ArrayList<>();
		BSTFreq root = new BSTFreq(nums[nums.length-1]);
		result.add(0);
		for(int i = nums.length-2; i >=0; i--){
			root = addValue(root, nums[i]);
			result.add(search(root, nums[i]));
		}
		Collections.reverse(result);
		return result;
    }

}
