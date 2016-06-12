package com.leetcode.solved;

public class RangeQuerySum2DImmutable {
    
    private int[][] tempMat;
    public RangeQuerySum2DImmutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        tempMat = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 1; i <= matrix.length; i++){
        	for(int j = 1; j <= matrix[0].length; j++){
        		tempMat[i][j] = matrix[i-1][j-1] + tempMat[i][j-1];
        	}
        }
        for(int i = 1; i < tempMat.length; i++){
        	for(int j = 0; j < tempMat[0].length; j++){
        		tempMat[i][j] += tempMat[i-1][j];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (tempMat[row2+1][col2+1] - tempMat[row2+1][col1] - tempMat[row1][col2+1] + tempMat[row1][col1]);
    }


	public static void main(String[] args){
		int[][] matrix = {
		                  {3, 0, 1, 4, 2},
		                  {5, 6, 3, 2, 1},
		                  {1, 2, 0, 1, 5},
		                  {4, 1, 0, 1, 7},
		                  {1, 0, 3, 0, 5}
		                };
		RangeQuerySum2DImmutable numMatrix = new RangeQuerySum2DImmutable(matrix);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
	}
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
 