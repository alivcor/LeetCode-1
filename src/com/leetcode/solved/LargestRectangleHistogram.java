package com.leetcode.solved;

import java.util.Stack;

public class LargestRectangleHistogram {
	/*
	 * L = left most large element
	 * R = rightmost large element
	 */
	public static int largestRectangleArea(int height[]){
		
		int L[] = new int[height.length];
		int R[] = new int[height.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < height.length; i ++){
			while(!stack.isEmpty()){
				if(height[i] <= height[stack.peek()]){
					stack.pop();
				}else{
					break;
				}
			}
			
			if(stack.isEmpty()){
				L[i] = i;
			}else{
				L[i] = i - stack.peek() - 1;
			}
			
			stack.add(i);
		}
		
		stack.clear();
		
		for(int i = height.length-1; i >= 0; i--){
			while(!stack.isEmpty()){
				if(height[i] <= height[stack.peek()]){
					stack.pop();
				}else{
					break;
				}
				
			}
			
			if(stack.isEmpty()){
				R[i] = height.length - i-1;
			}else{
				R[i] = stack.peek() - i-1;
			}
			
			stack.add(i);
		}
		
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i < height.length; i++){
			maxArea = (maxArea > (R[i] + L[i] + 1)*height[i]) ? maxArea : (L[i] + R[i] + 1)*height[i];
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		int height[] = {9,6,2,1,3,5,4,8,2,7};
		System.out.println(largestRectangleArea(height));

	}

}
