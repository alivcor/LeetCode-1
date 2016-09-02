package com.leetcode.solved;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        return findMin(nums,0,nums.length-1);
    }
    
    private int findMin(int[] array, int start, int end){
        if(start >= end || array[start] < array[end]) return array[start];
        if(start + 1 == end) return Integer.min(array[start],array[end]);
        int mid = (start + end)/2;
        if(array[mid] > array[start]) return findMin(array,mid+1,end);
         return findMin(array,start,mid);
        
    }
}
