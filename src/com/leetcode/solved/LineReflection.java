package com.leetcode.solved;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {

	public static boolean isReflected(int[][] points) {
        if(points == null || points.length == 0) return true;
        
        int[] leftMost = points[0];
        int[] rightMost = points[0];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] < leftMost[0]) leftMost = points[i];
            if(points[i][0] > rightMost[0]) rightMost = points[i];
        }
        
        if(leftMost[1] != rightMost[1]) return false;
        double probableLineX = (leftMost[0] + rightMost[0])/2.0;
        
        Set<String> mapLines = new HashSet<>();
        Set<String> lineSet = new HashSet<>();
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            if(lineSet.contains(x + "_" + y))continue;
            lineSet.add(x + "_" + y);
            if(x*1.0 == probableLineX) continue;
            if(mapLines.contains((2*probableLineX - x) + "_" + y)){
                    mapLines.remove((2*probableLineX - x) + "_" + y);
                }
                else mapLines.add(x*1.0 + "_" + y);
        }
        
        return mapLines.size() == 0;
        
    }
	public static void main(String[] args) {
		int[][] points = {{2,0},{2,1},{2,2},{2,3},{2,4},{-2,0},{-2,1},{-2,2},{-2,3},{-2,4}};
		System.out.println(isReflected(points));

	}

}
