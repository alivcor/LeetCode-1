package com.leetcode.solved;

import java.util.HashSet;
import java.util.Set;

public class ID391_PerfectRectangle {
	/*
    https://discuss.leetcode.com/topic/56052/really-easy-understanding-solution-o-n-java
    Condition for correct answer:
    1. Sum of areas of smaller rectangles should be equal to the area of larger.
    2. All points should appear in pairs except the 4 corners.
    */
    public boolean isRectangleCover(int[][] Rs) {
        if(Rs == null || Rs.length == 0) return false;
        if(Rs.length == 1) return true;
        
        Set<String> points = new HashSet<>();
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        
        long area = 0;
        
        for(int[] rect : Rs){
            xMin = Math.min(xMin, rect[0]);
            yMin = Math.min(yMin, rect[1]);
            xMax = Math.max(xMax, rect[2]);
            yMax = Math.max(yMax, rect[3]);
            
            area += (rect[2] - rect[0])*(rect[3] - rect[1]);
            String p1 = rect[0] + "_" + rect[1];
            String p2 = rect[0] + "_" + rect[3];
            String p3 = rect[2] + "_" + rect[1];
            String p4 = rect[2] + "_" + rect[3];
            if(!points.add(p1)) points.remove(p1);
            if(!points.add(p2)) points.remove(p2);
            if(!points.add(p3)) points.remove(p3);
            if(!points.add(p4)) points.remove(p4);
        }
        
        if(!points.contains(xMin + "_" + yMin) || !points.contains(xMin + "_" + yMax) || 
            !points.contains(xMax + "_" + yMin) || !points.contains(xMax + "_" + yMin) || points.size() != 4) return false;
            
        return area == (long)(xMax - xMin) * (yMax - yMin);
        
    }
}
