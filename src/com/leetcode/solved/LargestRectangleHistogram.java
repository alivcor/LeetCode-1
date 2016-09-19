package com.leetcode.solved;

import java.util.Stack;

public class LargestRectangleHistogram {
	/*
	 * L = left most large element
	 * R = rightmost large element
	 */
	public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = (i == heights.length) ? 0 : heights[i];
            if(stack.isEmpty() || heights[stack.peek()] < h) stack.push(i);
            else {
                //top element of stack is greater than current at i
                int top = stack.pop();
                int diff_in_index = ((stack.isEmpty()) ? i : i - (1 + stack.peek()));
                maxArea = Integer.max(maxArea, heights[top]*diff_in_index);
                i--;
            }
        }
        
        return maxArea;
    }

	public static void main(String[] args) {
		int height[] = {9,6,2,1,3,5,4,8,2,7};
		System.out.println(largestRectangleArea(height));

	}

}
