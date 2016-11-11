package com.leetcode.solved;

public class ID410_SplitArrayLargestSum {
	/*
    https://discuss.leetcode.com/topic/61324/clear-explanation-8ms-binary-search-java
    
    Use Binary Search to find this value. 
    This value can only be between max(array) and sum of array
    Calulate the mid
    Everytime start from Left side, as soon as the sum of value crosses mid, increase the count
    If we we reached the count as m and still have elements left, this means that we can have greater value of mid
    else if we have exhausted all value and still count is less we need to reduce mid.
    
    */
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return 0;
        long left = 0;
        long right = 0;
        for(int i = 0; i < nums.length; i++){
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        if(m == 1) return (int)right;
        while(left <= right){
            long mid = (left + right)/2;
            if(isValid(nums, mid, m)) right = mid - 1;
            else left = mid + 1;
        }
        
        return (int)left;
    }
    
    private static boolean isValid(int[] nums, long target, int m){
        int count = 1;
        long curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            if(curSum > target){
                curSum = nums[i];
                count++;
                if(count > m) return false;
            }
        }
        
        return true;
    }

}
