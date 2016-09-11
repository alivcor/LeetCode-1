package com.leetcode.solved;

public class RotateFunction {
	public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0) return 0;
        int sumArray = 0;
        int curSum = 0;
        for(int i = 0; i < A.length; i++) {
            sumArray+= A[i];
            curSum += i*A[i];
        }
        
        int maxSum = curSum;
        for(int i = A.length -1; i > 0; i--){
            curSum = curSum + sumArray - (A.length)*A[i];
            maxSum = Integer.max(maxSum,curSum);
        }
        
        return maxSum;
        
    }

}
