package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPathMatrix {
	static Map<String,Integer> dpMap = new HashMap<String,Integer>();
    public static int longestIncreasingPath(int[][] matrix) {
    	dpMap = new HashMap<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxLength = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                maxLength = Integer.max(maxLength, maxLength(matrix,i,j,matrix[i][j]-1));
            }
        }
        return maxLength;
    }
    
    private static int retMax(int a, int b, int c, int d){
        return (Integer.max(Integer.max(a,b), Integer.max(c,d)));
    }
    private static int maxLength(int[][] matrix, int x, int y, int val){
        
        if(x < 0 || x == matrix.length || y < 0 || y == matrix[0].length) return 0;
        if(matrix[x][y] <= val) return 0;
        if(dpMap.get(x + "_" + y) != null) return dpMap.get(x + "_" + y);
        
        int temp = matrix[x][y];
        matrix[x][y] = Integer.MIN_VALUE;
        int result =  retMax(
            maxLength(matrix,x+1,y,temp),
            maxLength(matrix,x-1,y,temp),
            maxLength(matrix,x,y+1,temp),
            maxLength(matrix,x,y-1,temp)
            );
        matrix[x][y] = temp;
        dpMap.put(x + "_" + y,1 + result); 
        return 1 + result;
    }



	public static void main(String[] args) {
//		int[][] nums = {
//		        {3,4,5},
//		        {3,2,6},
//		        {2,2,1}};
		int[][] nums = {{1,2}};
		System.out.println(longestIncreasingPath(nums));

	}

}
