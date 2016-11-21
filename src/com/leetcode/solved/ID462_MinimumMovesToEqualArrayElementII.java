package com.leetcode.solved;

import java.util.Arrays;

public class ID462_MinimumMovesToEqualArrayElementII {
	/*
    The solution would be to make each element the median.
    */
    public int minMoves2_old(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        if(nums.length%2 == 1){
            int sol = 0;
            for(int i = 0; i < nums.length; i++) sol += Math.abs(nums[i] - nums[nums.length/2]);
            return sol;
        }
        
        
        long pot1 = nums[nums.length/2 - 1];
        long pot2 = nums[nums.length/2];
        int sol1 = 0;
        int sol2 = 0;
        for(int i = 0; i < nums.length; i++){
            sol1 += Math.abs(nums[i] - pot1);
            sol2 += Math.abs(nums[i] - pot2);
        } 
        
        return Math.min(sol1, sol2);
        
    }
    
    /*
    Another way is to find the above median in O(N) time using quick select.
    */
    
    public int minMoves2(int[] nums){
        if(nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            count += nums[right--] - nums[left++];
        }
        
        return count;
    }

}
