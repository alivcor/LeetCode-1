package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
	 public int minTotalDistance(int[][] grid) {
	        List<Integer> rows = new ArrayList<>();
	        List<Integer> cols = new ArrayList<>();
	        
	        for(int i = 0; i < grid.length; i++){
	            for(int j = 0; j < grid[0].length; j++){
	                if(grid[i][j] == 1){
	                    rows.add(i);
	                    cols.add(j);
	                }
	            }
	        }
	        return getMin(rows) + getMin(cols);
	    }
	    
	    private int getMin(List<Integer> list){
	        Collections.sort(list);
	        int i = 0;
	        int j = list.size() - 1;
	        int total = 0;
	        while(i < j){
	            total += list.get(j--) - list.get(i++);
	        }
	        return total;
	    }
}
