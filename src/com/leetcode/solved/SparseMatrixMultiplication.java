package com.leetcode.solved;

public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null) return new int[0][0];
        
        int[][] result = new int[A.length][B[0].length];
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 0) continue;
                for(int k = 0; k < B[0].length; k++){
                    if(B[j][k] == 0)continue;
                    result[i][k] += A[i][j]*B[j][k];
                }
            }
        }
        
        return result;
    }

}
