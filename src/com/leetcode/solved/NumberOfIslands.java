package com.leetcode.solved;

public class NumberOfIslands {

	private static void markLand(char[][] grid, int x, int y){
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
		grid[x][y] = '0';
		markLand(grid, x+1, y);
		markLand(grid, x, y+1);
		markLand(grid, x-1, y);
		markLand(grid, x, y-1);
	}
	public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == '1'){
        			count++;
        			markLand(grid, i, j);
        		}
        	}
        }
        
        return count;
    }
	
	public static void  main(String args[]){
		char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		System.out.println(numIslands(grid));
	}
}
