package com.leetcode.solved;

public class ID414_ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Integer maxVal = null;
        Integer maxVal2 = null; 
        Integer maxVal3 = null;
        
        for(int i = 0; i < nums.length; i++){
            if(maxVal == null || nums[i] > maxVal){
                maxVal3 = maxVal2;
                maxVal2 = maxVal;
                maxVal = nums[i];
            }else if((maxVal2 == null || nums[i] > maxVal2) && nums[i] != maxVal){
                maxVal3 = maxVal2;
                maxVal2 = nums[i];
            }else if((maxVal3 == null || nums[i] > maxVal3) && (maxVal2 == null || maxVal2 != nums[i]) && maxVal != nums[i]){
                maxVal3 = nums[i];
            }
        }
        
        return (int)((maxVal3 == null) ? maxVal : maxVal3);
    }

}
