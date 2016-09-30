package com.leetcode.solved;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int colVal[] = new int[grid[0].length];
        int maxEnemy = 0;
        int row = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'W') continue;
                if(i == 0 || grid[i-1][j] == 'W') colVal[j] = killEnemyCol(i, j, grid);
                if(j == 0 || grid[i][j-1] == 'W') row = killEnemyRow(i, j, grid);
                if(grid[i][j] == '0') maxEnemy = Math.max(maxEnemy, row + colVal[j]);
            }
        }
        
        return maxEnemy;
        
    }
    
    private int killEnemyRow(int i, int j, char[][] grid){
        int count = 0;
        while(j < grid[0].length && grid[i][j] != 'W'){
            count += ((grid[i][j] == 'E') ? 1 : 0);
            j++;
        }
        return count;
    }
    
    private int killEnemyCol(int i, int j, char[][] grid){
        int count = 0;
        while(i < grid.length && grid[i][j] != 'W'){
            count += ((grid[i][j] == 'E') ? 1 : 0);
            i++;
        }
        return count;
    }

}
