package com.leetcode.solved;

public class PaintHouseII {

	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int min = -1;
        int min2 = -1;
        
        for(int i = 0; i < costs.length; i++){
            int umin = -1;
            int umin2 = -1;
            for(int j = 0; j < costs[i].length; j++){
                if(j != min) costs[i][j] += (min < 0) ? 0 : costs[i-1][min];
                else costs[i][j] += (min2 < 0) ? 0 : costs[i-1][min2];
                
                if(umin < 0 || costs[i][j] < costs[i][umin]){
                    umin2 = umin;
                    umin = j;
                }else if(umin2 < 0 || costs[i][j] >= costs[i][umin] && costs[i][j] < costs[i][umin2]) umin2 = j;
            }    
            
            min = umin;
            min2 = umin2;
        }
        
        return costs[costs.length-1][min];
    }
}
