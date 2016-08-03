package com.leetcode.solved;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[right]){
                //mid is in rotated part and smallest element is towards right
                if(nums[mid] > target && nums[left] <= target){
                    //left and mid ke beech  mein
                    right = mid;
                }else left = mid+1;
            }else if(nums[mid] < nums[right]){
                if(nums[mid] < target && nums[right] >= target) left = mid+1;
                else right = mid;
            }else right--;
        }
        
        return nums[left] == target;
        
    }

}
