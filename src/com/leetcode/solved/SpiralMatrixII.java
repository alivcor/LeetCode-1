package com.leetcode.solved;

public class SpiralMatrixII {
	/*
	 * Start from one corner and keep filling rows and columns until we reach the centre element.
	 */
	 public static int[][] generateMatrix(int n) {
		 int array[][] = new int[n][n];
		 
		 int count = 1;
		 for(int i = 0; i <= n/2; i++){
			 for(int j = i; j < n-i;j++){
				 array[i][j] = count++;
			 }
			 
			 for(int j = i+1; j < n - i; j++){
				 array[j][n-i-1] = count++;
			 }
			 
			 for( int j = n-i-2; j > i; j--){
				 array[n-i-1][j] = count++;
			 }
			 
			 for(int j = n-i-1; j > i; j--){
				 array[j][i] = count++;
			 }
		 }
		 
		 return array;
	 }
	public static void main(String[] args) {
		generateMatrix(6);

	}

}
