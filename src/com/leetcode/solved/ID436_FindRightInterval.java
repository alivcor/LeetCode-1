package com.leetcode.solved;

import java.util.TreeMap;

public class ID436_FindRightInterval {
	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
	}
	
	public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null) return new int[0];
        
        TreeMap<Integer,Integer> indexMap = new TreeMap<>();
        
        for(int i = 0; i < intervals.length; i++){
            indexMap.put(intervals[i].start, i);
        }
        
        int[] result = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
        	result[i] = (indexMap.ceilingKey(intervals[i].end) == null) ? -1 : indexMap.get(indexMap.ceilingKey(intervals[i].end));
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
