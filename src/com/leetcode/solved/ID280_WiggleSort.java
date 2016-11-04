package com.leetcode.solved;

import java.util.Arrays;

public class ID280_WiggleSort {
	 public void wiggleSort_OnlogN(int[] nums) {
         if(nums == null) return;
         Arrays.sort(nums);
         int index = 2;
         while(index < nums.length){
             int temp = nums[index-1];
             nums[index-1] = nums[index];
             nums[index] = temp;
             index+=2;
         }
     }
    
    private void swap(int a, int b, int nums[]){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void wiggleSort(int[] nums) {
        if(nums == null) return;
        for(int i = 1; i < nums.length; i++){
            if(i%2 == 1 && nums[i-1] > nums[i])swap(i-1, i, nums);
            else if(i%2 == 0 && nums[i-1] < nums[i]) swap(i-1, i, nums);
        }
    }
}
