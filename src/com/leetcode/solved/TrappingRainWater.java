package com.leetcode.solved;

public class TrappingRainWater {
	public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int totalSum = 0;
        int left = 0;
        int maxLeft = 0;
        int right = height.length - 1;
        int maxRight = 0;
        
        while(left <= right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft) maxLeft = height[left];
                else totalSum += maxLeft - height[left];
                left++;
            }else{
                if(height[right] >= maxRight) maxRight = height[right];
                else totalSum += maxRight - height[right];
                right--;
            }
        }
        
        return totalSum;
    }
}
