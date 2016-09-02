package com.leetcode.solved;

public class PaintHouse {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int red = 0;
        int blue = 0;
        int green = 0;
        for(int i = 1; i <= costs.length; i++){
            int nRed = Integer.min(blue + costs[i-1][0],green + costs[i-1][0]);
            int nBlue = Integer.min(red + costs[i-1][1],green + costs[i-1][1]);
            green = Integer.min(red + costs[i-1][2],blue + costs[i-1][2]);
            red = nRed;
            blue = nBlue;
        }
        
        return Integer.min(red,Integer.min(blue,green));
    }
}
