package com.leetcode.solved;

public class FindPeakElement {

	public static int findPeakElement(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		if(nums.length == 1) return 0;
		
		return findPeakElement(nums, 0, nums.length-1);
    }
	
	/** To understand this question. Assume this as a mountain range.
	 * Now we know that the area before the leftmost element is at below sea level
	 * and so is the area after the right most.
	 * Now if we are at any given point, take the side going upward,
	 * since we know that at some point of time we will reach the sea level(-inf).
	 * We would have to turn the direction, and that my friend, would be a peak for us.
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	public static int findPeakElement(int nums[], int start, int end){
		if(start == end) return start;
		if(start + 1 == end) return (nums[start] > nums[end]) ? start : end;
		
		int mid = (start + end)/2;
		if(nums[mid] > nums[mid-1]){
			return findPeakElement(nums,mid,end);
		}
		
		return findPeakElement(nums, start, mid);
	}
	public static void main(String[] args) {
		int array[] = {1, 7, 3, 4};
		System.out.println(findPeakElement(array));

	}

}
