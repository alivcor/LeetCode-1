package com.leetcode.solved;

public class ID463_IslandPerimeter {
	int count = 0;
	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public int islandPerimeter(int[][] map){
		if(map == null || map.length == 0 || map[0].length == 0) return 0;
		for(int i = 0; i < map.length; i++){
		    for(int j = 0; j < map[0].length; j++){
		        if(map[i][j] == 1){
		            periFind(map, i, j);
		            return count;
		        }
		    }
		}
		
		return 0;
	}
	
	private boolean periFind(int[][] grid, int x, int y){
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
		if(grid[x][y] == 2) return true;
		if(grid[x][y] == 0) return false;
		grid[x][y] = 2;
		for(int i = 0; i < dir.length; i++){
			if(!periFind(grid, x + dir[i][0], y + dir[i][1])){
				count++;
			}
		}
		return true;
	}

}
