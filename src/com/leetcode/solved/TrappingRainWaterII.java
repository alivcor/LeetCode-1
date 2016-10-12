package com.leetcode.solved;

import java.util.PriorityQueue;

public class TrappingRainWaterII {

	public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> (Integer.compare(a[2], b[2])));
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        
        for(int i = 0; i < heightMap.length; i++){
            visited[i][0] = true;
            visited[i][heightMap[0].length - 1] = true;
            queue.add(new int[]{i,0,heightMap[i][0]});
            queue.add(new int[]{i,heightMap[0].length - 1,heightMap[i][heightMap[0].length - 1]});
        }
        for(int i = 0; i < heightMap[0].length; i++){
            visited[0][i] = true;
            visited[heightMap.length - 1][i] = true;
            queue.add(new int[]{0,i,heightMap[0][i]});
            queue.add(new int[]{heightMap.length - 1,i,heightMap[heightMap.length - 1][i]});
        }
        
        int total = 0;
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            for(int[] d : dirs){
                int row = top[0] + d[0];
                int col = top[1] + d[1];
                if(row < 0 || row > heightMap.length - 1 || col < 0 || col > heightMap[0].length - 1 || visited[row][col]) continue;
                visited[row][col] = true;
                total += Math.max(0, top[2] - heightMap[row][col]);
                queue.add(new int[]{row, col, Math.max(heightMap[row][col], top[2])});
            }
                        
        }
        
        return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
