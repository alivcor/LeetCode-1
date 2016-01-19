package com.leetcode.solved;

public class SearchInA2DMatrixII {
	/*
	 * Performing a cell by cell search would give the correct answer but, 
	 * than we would not use the fact of Row and Columns being sorted.
	 * 
	 * To do this in O(N) we will start from the top right, we can also start
	 * from the bottom left.
	 * Only reason to start from top left or bottom right is that, for a
	 * particular condition, we can just move in one direction.
	 * 
	 * For instance, if we are search for a number N and we figured out that
	 * N is smaller than the given number in Matrix.
	 * So, we will have no reason to go down, as everything down from this location
	 * is greater than that element in Matrix.
	 * 
	 * So go left.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null ||  matrix.length == 0 || matrix[0].length == 0) return false;
        
        int i = 0;
        int j = matrix[0].length - 1;
        
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) j--;
            else i++;
        }
        
        return false;
    }
}
