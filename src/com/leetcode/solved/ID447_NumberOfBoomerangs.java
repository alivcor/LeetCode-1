package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class ID447_NumberOfBoomerangs {
	/*
    For each of the points, create a map of distance, count of points,
    Since order matters, so if total count of points at a distance of k is N.
    Total tuples: N * (N - 1)
    */
    private long distance(int[] point1, int[] point2){
        return (point1[0] - point2[0])*(point1[0] - point2[0]) + 
                (point1[1] - point2[1])*(point1[1] - point2[1]);
    }
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0) return 0;
        
        int count = 0;
        for(int i = 0; i < points.length; i++){
            Map<Long, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                long distance = distance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance,0) + 1);
            }
            for(Long key : map.keySet()) count += map.get(key)*(map.get(key) - 1);
        }
        
        return count;
        
    }

}
