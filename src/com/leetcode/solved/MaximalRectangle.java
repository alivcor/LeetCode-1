package com.leetcode.solved;

import java.util.Stack;

public class MaximalRectangle {

	public static int maximalRectangle(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0) return 0;
		
		int[][] array = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++){
			array[0][i] = matrix[0][i] - 48;
		}
		
		int maxArea =  largestRectangleArea(array[0]);
		for(int i = 1; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == '1'){
					array[i][j] = array[i-1][j] + 1;
				}
			}
			int currMax = largestRectangleArea(array[i]);
			maxArea = (maxArea > currMax ? maxArea : currMax);
		}
		
		return maxArea;
        
    }
	
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
		char[][] arr = {{'0','0'},{'1','1'},{'1','1'},{'1','1'}};
		System.out.println(maximalRectangle(arr));

	}

}
