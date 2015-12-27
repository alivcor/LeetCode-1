package com.leetcode.solved;

public class RemoveElement {
	
	/*
	 * Traverse from both direction. 
	 * Find first val from left and first nonval from right.
	 * Swap. 
	 */
	 public static int removeElement(int[] nums, int val) {
	     
		 if(nums == null || nums.length == 0) return 0;
		 int count = 0;
		 for(int curVal: nums){
			 if(curVal == val) count++;
		 }
	     
		 int leftIndex = 0;
		 int rightIndex = nums.length-1;
		 while(leftIndex < rightIndex){
			 while(leftIndex < rightIndex && nums[leftIndex] != val)leftIndex++;
			 while(leftIndex < rightIndex && nums[rightIndex] == val)rightIndex--;
			 if(leftIndex >= rightIndex)break;
			 nums[leftIndex++] = nums[rightIndex];
			 nums[rightIndex--] = val;
	    }
		
		return nums.length-count;
	}

	private static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

	public static void main(String[] args) {
		int iparray[] = {1,2,3,2,3,2,1,1};
		System.out.println(removeElement(iparray, 2));

	}

}
