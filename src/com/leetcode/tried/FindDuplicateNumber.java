package com.leetcode.tried;

import java.util.Arrays;

public class FindDuplicateNumber {
	
	public static int binSearch(int[] array, int start, int end){
		if(start > end) return -1;
		if(start == end) return start;
		int mid = (start + end)/2;
		if(array[mid] == mid + 1){
			if(end > mid && array[mid+1] == mid + 1){
				return mid+1;
			}
			return binSearch(array, mid, end);
		}
		
		return binSearch(array, start, mid);
	}

	public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return binSearch(nums, 0, nums.length-1);
    }
	public static void main(String[] args) {
		int[] nums = {1,2,4,4,4};
		System.out.println(findDuplicate(nums ));

	}

}
