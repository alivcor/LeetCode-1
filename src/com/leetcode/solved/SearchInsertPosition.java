package com.leetcode.solved;

public class SearchInsertPosition {
	
	public static int binSearch(int array[], int start, int end, int val){
		if(start == end && array[start] == val) return start;
		
		int mid = (start + end)/2;
		
		if(array[mid] == val) return mid;
		
		if(array[mid] > val){
			if(start == mid) return start;
			if(array[mid-1] < val) return mid;
			return binSearch(array, start, mid-1, val);
		}
		
		if(end == mid) return (end+1);
		if(array[mid+1] > val) return mid+1;
		return binSearch(array, mid+1, end, val);
	}
	
	public static int searchInsert(int[] nums, int target) {
        return binSearch(nums, 0, nums.length-1, target);
    }

	public static void main(String[] args) {
		int nums[] = {1,3,5,6};
		System.out.println(searchInsert(nums, 0));
	}

}
/*
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/