package com.leetcode.solved;


public class PatchingArray {
	
	public static int minPatches(int[] nums, int n){
		if(nums == null || n == 0) return 0;
		int count = 0;
		
		long miss = 1;
		int index = 0;
		while(miss <= n){
			//Since we can construct all the numbers from [0,miss).
			//If we have a number < miss, we can add that and update our dataset 
			//to have number [0,miss+number)
			if(index < nums.length && nums[index] <= miss){
				miss += nums[index++];
			}else{
				//If there is no number smaller than miss.
				count++;
				miss += miss;
			}
		}
		
		return count;
	}	
	public static void main(String[] args) {
		int[] array = {1,2,31,33};
		System.out.println(minPatches(array, 2147483647));

	}

}
