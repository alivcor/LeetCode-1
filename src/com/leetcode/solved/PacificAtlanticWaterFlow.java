package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	public static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<int[]>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
        	dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
        	dfs(matrix, atlantic, i, matrix[0].length-1, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < matrix[0].length; i++){
        	dfs(matrix,pacific,0,i, Integer.MIN_VALUE);
        	dfs(matrix,atlantic,matrix.length-1, i, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		if(pacific[i][j]&atlantic[i][j]) result.add(new int[]{i,j});
        	}
        }
        return result;
    }
	
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	private static void dfs(int[][] matrix,boolean[][] grid, int x, int y,int height){
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] || matrix[x][y] < height) return;
		grid[x][y] = true;
		
		for(int[] d : dir){
			dfs(matrix, grid, x + d[0], y + d[1], matrix[x][y]);
		}
	}
	public static void main(String[] args) {
		System.out.println(pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
//		System.out.println(pacificAtlantic(new int[][]
//				{{11,3,2,4,14,6,13,18,1,4,12,2,4,1,16},
//				 {5,11,18,0,15,14,6,17,2,17,19,15,12,3,14},
//				 {10,2,5,13,11,11,13,19,11,17,14,18,14,3,11},
//				 {14,2,10,7,5,11,6,11,15,11,6,11,12,3,11},
//				 {13,1,16,15,8,2,16,10,9,9,10,14,7,15,13},
//				 {17,12,4,17,16,5,0,4,10,15,15,15,14,5,18},
//				 {9,13,18,4,14,6,7,8,5,5,6,16,13,7,2},
//				 {19,9,16,19,16,6,1,11,7,2,12,10,9,18,19},
//				 {19,5,19,10,7,18,6,10,7,12,14,8,4,11,16},
//				 {13,3,18,9,16,12,1,0,1,14,2,6,1,16,6},
//				 {14,1,12,16,7,15,9,19,14,4,16,6,11,15,7},
//				 {6,15,19,13,3,2,13,7,19,11,13,16,0,16,16},
//				 {1,5,9,7,12,9,2,18,6,12,1,8,1,10,19},
//				 {10,11,10,11,3,5,12,0,0,8,15,7,5,13,19},
//				 {8,1,17,18,3,6,8,15,0,9,8,8,12,5,18},
//				 {8,3,6,12,18,15,10,10,12,19,16,7,17,17,1},
//				 {12,13,6,4,12,18,18,9,4,9,13,11,5,3,14},
//				 {8,4,12,11,2,2,10,3,11,17,14,2,17,4,7},
//				 {8,0,14,0,13,17,11,0,16,13,15,17,4,8,3},
//				 {18,15,8,11,18,3,10,18,3,3,15,9,11,15,15}}));

	}

}
