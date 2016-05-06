package com.leetcode.solved;


public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int array[][] = new int[matrix.length][matrix[0].length];
		
		int maxVal = 0;
		for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
            	array[i][j] = matrix[i][j] - 48;
            	if(array[i][j] > maxVal) maxVal = array[i][j];
            }
		}
		
        for(int i = 1; i < array.length; i++){
            for(int j = 1; j < array[0].length; j++){
            	array[i][j] = (array[i][j] == 0) ? 0:
                	(1 + Integer.min(array[i-1][j],Integer.min(array[i][j-1],array[i-1][j-1])));
            	if(array[i][j] > maxVal) maxVal = array[i][j];  
            }
        }
        
        return maxVal*maxVal;
        
    }

	public static void main(String[] args) {
		char[][] matrix = {{'1','1'},{'1','1'}};
		System.out.println(maximalSquare(matrix));

	}

}
