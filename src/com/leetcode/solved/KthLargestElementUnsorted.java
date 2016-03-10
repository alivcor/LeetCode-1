package com.leetcode.solved;

public class KthLargestElementUnsorted {

	public static int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length < k) return -1;
		return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }
	
	public static int quickSort(int nums[], int start, int end, int k){
		if(start >= end) return (start == k) ? nums[start] : -1;
		int sIndex = start + 1;
		int eIndex = end;
		
		int pivot = nums[start];
		while(sIndex <= eIndex){
			if(nums[sIndex] < pivot) sIndex++;
			else if(nums[eIndex] > pivot) eIndex--;
			else{
				int temp = nums[sIndex];
				nums[sIndex++] = nums[eIndex];
				nums[eIndex--] = temp;
			}
		}
		
		sIndex--;
		int temp = nums[sIndex];
		nums[sIndex] = nums[start];
		nums[start] = temp;
		if(sIndex == k) return nums[sIndex];
		if(k > sIndex) return quickSort(nums, sIndex+1,end, k); 
		return quickSort(nums, start, sIndex-1, k);
	}

	public static void main(String[] args) {
		int[] nums = {2,1};//{5,4,12,1,6,2,3};
		for(int i = 0; i < nums.length; i++)
			System.out.println(findKthLargest(nums,i+1));
//		for(int i = 0; i < nums.length; i++){
//			System.out.print(nums[i] + " ");
//		}
		

	}

}
