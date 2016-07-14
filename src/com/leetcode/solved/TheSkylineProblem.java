package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	public static List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0)return Collections.emptyList();
        List<int[]> height = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        
        for(int i = 0; i < buildings.length; i++){
        	height.add(new int[]{buildings[i][0],-buildings[i][2]});
        	height.add(new int[]{buildings[i][1],buildings[i][2]});
        }
        Collections.sort(height, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		}); 
        
        int previous = 0;
        queue.add(0);
        for(int[] currentB : height){
        	if(currentB[1] < 0) queue.add(-currentB[1]);
        	else queue.remove(currentB[1]);
        	
        	if(previous != queue.peek()){
        		result.add(new int[]{currentB[0],queue.peek()});
        		previous = queue.peek();
        	}
        }
        
        return result;
    }

}
