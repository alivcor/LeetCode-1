package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> result = new ArrayList<>();
    	if(intervals == null && newInterval == null) return result;
    	if(intervals == null){
    		result.add(newInterval);
    		return result;
    	}
	
        int index = 0;
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) result.add(intervals.get(index++));
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end){
    		newInterval.start = Integer.min(newInterval.start, intervals.get(index).start);
    		newInterval.end = Integer.max(newInterval.end, intervals.get(index).end);
        	index++;
        }
        result.add(newInterval);
        while(index < intervals.size()) result.add(intervals.get(index++));
        return result;
	}

}
