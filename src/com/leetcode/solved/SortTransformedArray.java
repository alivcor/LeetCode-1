package com.leetcode.solved;

public class SortTransformedArray {
	/*
    when a > 0 : The largest element would be at the ends(square values)
    when a < 0: The largest element would be at middle somewhere
    */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) return new int[0];
        
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = (a > 0) ? nums.length - 1 : 0;
        
        while(left <= right){
            int vLeft = applyFunc(nums[left],a,b,c);
            int vRight = applyFunc(nums[right],a,b,c);
            if(a > 0){
                //largest at end.
                if(vLeft > vRight){
                    result[index--] = vLeft; 
                    left++;
                } else{
                    result[index--] = vRight;
                    right--;
                }
            }else{
                //largest at mid
                if(vLeft < vRight){
                    result[index++] = vLeft; 
                    left++;
                } else{
                    result[index++] = vRight;
                    right--;
                }
            }
        }
        return result;
    }
    
    private int applyFunc(int x, int a, int b, int c){
        return (a*x*x + b*x + c);
    }
}
