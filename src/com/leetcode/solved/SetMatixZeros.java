package com.leetcode.solved;

public class SetMatixZeros {

	/**If we try to zero a row or column as soon as we discover a zero,
	 * We will end up zeroing almost all the whole Matrix.
	 * Since we also want to do it inplace, we will use the first row
	 * and first column of the Matrix to solve this.
	 * 
	 * Flow:
	 * Save the state of first row and first column, that they 
	 * are supposed to be Zero or not at the end.
	 * 
	 * For all other cell, update the corrosponding first row and column.
	 * Once done, update the values.
	 * @param matrix
	 */
	
	private static void setRowZero(int[][] matrix, int rowNum){
		for(int i = 0; i < matrix[0].length; i++)
			matrix[rowNum][i] = 0;
	}
	private static void setColZero(int[][] matrix, int colNum){
		for(int i = 0; i < matrix.length; i++)
			matrix[i][colNum] = 0;
	}
	
	public static void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		
		boolean isFirstRow0 = false;
		boolean isFirstCol0 = false;
		for(int i = 0; i < matrix.length; i++){
			if(matrix[i][0] == 0){
				isFirstCol0 = true;
				break;
			}
		}
		
		for(int i = 0; i < matrix[0].length; i++){
			if(matrix[0][i] == 0){
				isFirstRow0 = true;
				break;
			}
		}
			
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < matrix[0].length; i++)
			if(matrix[0][i] == 0) setColZero(matrix, i);
		
		for(int i = 1; i < matrix.length; i++)
			if(matrix[i][0] == 0) setRowZero(matrix, i);
		
		if(isFirstCol0) setColZero(matrix, 0);
		if(isFirstRow0) setRowZero(matrix, 0);
		
		return;
    }
	public static void main(String[] args) {
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		
		setZeroes(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
