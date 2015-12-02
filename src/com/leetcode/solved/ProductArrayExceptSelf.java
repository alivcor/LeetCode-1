package com.leetcode.solved;

public class ProductArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
        
        if(nums == null || nums.length == 0) return null;
        
        int[] result = new int[nums.length];
        int prod = 1;
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            prod *= nums[i-1];
            result[i] = prod;
        }
        
        prod = nums[nums.length-1];
        nums[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            prod *= nums[i+1];
            result[i] = result[i] * prod;
        }
        
        result[nums.length-1] *= nums[nums.length-1];
        
        return result;
    }
	public static void main(String[] args) {
		int[] nums = {9,0,-2};
		System.out.println(productExceptSelf(nums));

	}

}
