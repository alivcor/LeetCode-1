package com.leetcode.solved;

import java.util.Arrays;

public class ID452_MinimumNumberArrowsToBurstBalloons {
	 /*
    Sort items on Start time, followed by end time.
    For every arrow, assign a max range it can go, 
    If the next balloon can be bursted within the previous arrow's scope, well and good, else we would need a new arrow.
    */
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int count = 1;
        Arrays.sort(points, (a,b) -> { if(a[0] == b[0]) return a[1] - b[1];
                                        return a[0] - b[0];
            });
            
        int curB = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= curB) curB = Math.min(curB, points[i][1]);
            else {
                count++;
                curB = points[i][1];
            }
        }
        
        return count;
    }

}
