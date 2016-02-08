package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class UniquePathII {

	Map<String,Integer> map = new HashMap();
    private int pathCount(int[][] grid, int x, int y){
        if(x >= grid.length || y >= grid[0].length || grid[x][y] == 1) return 0;
        if(x == grid.length - 1 && y == grid[0].length - 1) return Math.abs(1 * (1 - grid[x][y]));

        if(map.get(x + "_" + y) != null) return map.get(x + "_" + y);
        
        
        map.put(x + "_" + y,pathCount(grid, x+1, y) + pathCount(grid, x, y + 1));
        
        return map.get(x + "_" + y);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        return pathCount(obstacleGrid, 0, 0);
    }
}
