package com.leetcode.solved;

public class RotateArray {

	private static void reverse(int nums[], int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
		return;
	}
	public static void rotate(int[] nums, int n){
		
		if(nums == null || nums.length == 0) return;
		n = n % (nums.length);
		if(n == 0) return;
		
		reverse(nums, 0, nums.length -1);
		reverse(nums, 0, n-1);
		reverse(nums, n, nums.length-1);
		
		return;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		rotate(array, 1);
		System.out.println(array);

	}

}
