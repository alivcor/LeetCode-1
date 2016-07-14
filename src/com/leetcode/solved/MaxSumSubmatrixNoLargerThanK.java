package com.leetcode.solved;

import java.util.TreeSet;

public class MaxSumSubmatrixNoLargerThanK {

	public static int findMaxUptoK(int array[], int k){
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		int globalMax = Integer.MIN_VALUE;
		int sum = 0;
		for(int ii = 0; ii < array.length; ii++){
			sum += array[ii];
			if(set.ceiling(sum - k) != null){
				globalMax = Integer.max(globalMax, sum - set.ceiling(sum - k));
			}
			set.add(sum);
		}
		return globalMax;
	}
	public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int globalMax = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
        	int tempArr[] = new int[matrix.length];
        	for(int j = i; j < matrix[0].length; j++){
        		for(int ii = 0; ii < matrix.length; ii++){
        			tempArr[ii] += matrix[ii][j];
        		}
        		globalMax = Integer.max(globalMax, findMaxUptoK(tempArr, k));
        	}
        }
        
        return globalMax;
    }
	public static void main(String[] args) {
//		int[][] matrix = {{1,  0, 1},{0, -2, 3}};
//		int k = 2;
//		System.out.println(maxSumSubmatrix(matrix, k));
		int[][] a = {{2,2,-1}};
		System.out.println(maxSumSubmatrix(a, 0));
	}

}
