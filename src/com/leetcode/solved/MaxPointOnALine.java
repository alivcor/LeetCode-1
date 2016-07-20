package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointOnALine {
	static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
	  Point(int a, int b) { x = a; y = b; }
	}
	public int maxPoints(Point[] points) {
        if(points == null) return 0;
        if(points.length <= 2) return points.length;
        
        int maxCount = 0;
        for(int i = 0; i < points.length; i++){
            int samePoints = 0;
            int samex = 1;
            Map<Double,Integer> mapSlope = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                double slope = 0;
                if(points[i].x == points[j].x && points[i].y == points[j].y) samePoints++;
                if(points[i].x == points[j].x){
                  samex++;
                  continue;
                } 
                slope = (double)(points[j].y - points[i].y)/(double)(points[j].x - points[i].x);
                if(!mapSlope.containsKey(slope)) mapSlope.put(slope,2);
                else mapSlope.put(slope,mapSlope.get(slope)+1);
                maxCount = Integer.max(maxCount, mapSlope.get(slope) + samePoints);
            }
            maxCount = Integer.max(maxCount,samex);
        }
        
        return maxCount;
    }	
	public static void main(String[] args){
		Point[] p = new Point[9];
		p[0] = new Point(84,250);
		p[1] = new Point(0,0);
		p[2] = new Point(1,0);
		p[3] = new Point(0,-70);
		p[4] = new Point(0,-70);
		p[5] = new Point(1,-1);
		p[6] = new Point(21,10);
		p[7] = new Point(42,90);
		p[8] = new Point(-42,-230);
	
	}
}
