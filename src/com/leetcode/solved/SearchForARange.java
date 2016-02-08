package com.leetcode.solved;

public class SearchForARange {
	private int findFirstOf(int[] nums, int start, int end, int value){
        if(start > end) return -1;
        
        int mid = (start + end)/2;
        if(nums[mid] == value){
            //Mid is the first occurance
            if(mid == start || (nums[mid] > nums[mid-1])) return mid;
        }
        
        if(nums[mid] >= value) return findFirstOf(nums, start, mid-1, value);
         return findFirstOf(nums, mid+1,end, value);
        
    }
    private int findLastOf(int[] nums, int start, int end, int value){
        if(start > end) return -1;
        
        int mid = (start + end)/2;
        if(nums[mid] == value){
            //Mid is the last occurance
            if(mid == end || (nums[mid] < nums[mid+1])) return mid;
        }
        
        if(nums[mid] > value) return findLastOf(nums, start, mid-1, value);
         return findLastOf(nums, mid+1,end, value);
        
    }
    public int[] searchRange(int[] nums, int target) {
        int result[] = {-1,-1};
        if(nums == null || nums.length == 0) return result;
        result[0] = findFirstOf(nums,0,nums.length-1, target);
        result[1] = findLastOf(nums,0,nums.length-1, target);
        
        return result;
        
    }

}
