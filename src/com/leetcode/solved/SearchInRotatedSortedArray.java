package com.leetcode.solved;

public class SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		int pivot = findPivot(nums, 0, nums.length-1);
		if(pivot == 0) return search(nums, 0, nums.length-1, target);
		if(target < nums[0]) return search(nums,pivot,nums.length-1, target);
		return search(nums,0,pivot-1,target);
    }
	
	private static int findPivot(int nums[], int start, int end){
		if(start == end || nums[start] < nums[end]) return start;
		
		int mid = start + (end - start)/2;
		if(mid > start && nums[mid] < nums[mid-1]) return mid;
		
		if(nums[mid] < nums[start]) return findPivot(nums, start, mid-1);
		return findPivot(nums, mid+1, end);
	}
	private static int search(int[] nums, int start, int end, int target) {
		if(start > end) return -1;
		int mid = (start + end)/2;
		
		if(nums[mid] == target) return mid;
		if(nums[mid] > target) return search(nums, start, mid-1, target);
		return search(nums, mid+1, end, target);
	}
	public static void main(String[] args) {
		int array[] = {4};
		for(int i = 0; i < array.length; i++){
			System.out.println(search(array, array[i]));
		}
		//System.out.println(search(array, 3));
		// TODO Auto-generated method stub

	}

}
