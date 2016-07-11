package com.leetcode.solved;

import java.util.Arrays;

public class DungeonGame {

	public static int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
		
		int m = dungeon.length;
		int n = dungeon[0].length;
		int soln[][] = new int[m+1][n+1];
		for(int i = 0; i <=m; i++){
			for(int j = 0; j <= n; j++){
				soln[i][j] = Integer.MAX_VALUE;
			}
		}
		soln[m][n-1] = soln[m-1][n] = 1;
//		
		for(int i = m-1; i >=0; i--){
			for(int j = n-1; j >=0; j--){
				//sum of minimum from down and right
				//both solns would be greater than zero
				
				int val = Integer.min(soln[i+1][j], soln[i][j+1]) - dungeon[i][j];
				soln[i][j] =  (val <= 0) ? 1 : val;  
			}
		}
		return soln[0][0];
	}
	
	public static void main(String[] args) {
		int[][] dungeon = {{-3,5}};
		System.out.println(calculateMinimumHP(dungeon));

	}

}
