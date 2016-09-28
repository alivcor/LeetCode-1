package com.leetcode.solved;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuilding {
    final int[] shift = new int[] {0, 1, 0, -1, 0};
    
    private boolean isValidEmptySpace(int x, int y, int[][] grid){
        return !(x < 0 || x > grid.length-1 || y < 0 || y > grid[0].length-1 || grid[x][y] != 0);
    }
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int dist[][] = new int[grid.length][grid[0].length];
        int reachable[][] = new int[grid.length][grid[0].length];
        int buildingCount = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    //isABuilding
                    buildingCount++;
                    boolean visited[][] = new boolean[grid.length][grid[0].length];
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.add(new int[]{i,j});
                    int level = 0;
                    while(!queue.isEmpty()){
                        int queueSize = queue.size();
                        //extract all values to keep level consistant.
                        for(int k = 0; k < queueSize; k++){
                            int[] top = queue.poll();
                            if(visited[top[0]][top[1]])continue;
                            
                            visited[top[0]][top[1]] = true;
                            dist[top[0]][top[1]] += level;
                            reachable[top[0]][top[1]]++;
                            
                            for(int dir = 0; dir < 4; dir++){
                                int x = top[0] + shift[dir];
                                int y = top[1] + shift[dir+1];
                                if(!isValidEmptySpace(x,y,grid) || visited[x][y])continue;
                                queue.add(new int[]{x,y});
                            }    
                        }
                        level++;
                    }
                    
                }
            }
        }
        
        int shortDis = Integer.MAX_VALUE;
                    for(int i = 0; i < dist.length; i++){
                        for(int j = 0; j < dist[0].length; j++){
                            if(shortDis > dist[i][j] && grid[i][j] == 0 && reachable[i][j] == buildingCount){
                                shortDis = dist[i][j];
                            }
                        }
                    }
                    
        return shortDis == Integer.MAX_VALUE ? -1 : shortDis;
        
    }
}