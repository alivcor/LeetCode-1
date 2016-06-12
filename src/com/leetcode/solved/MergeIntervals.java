package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	/*
	 * 1. Can't be merged: High1 < Low2 -1 OR High2 < Low1 - 1.
	 * 2. One already inside other: Low1 < Low2 && High1 > High2
	 * 3. Merge:High1 == Low2 - 1
	 */

	public static class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	      
	}
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) return Collections.emptyList();
		intervals.sort((a,b) -> Integer.compare(a.start, b.start));	
		List<Interval> result = new ArrayList<Interval>();
		result.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); i++){
			if(result.get(result.size() - 1).end >= intervals.get(i).start)
				result.get(result.size() - 1).end = Integer.max(result.get(result.size() - 1).end, intervals.get(i).end);
			else result.add(intervals.get(i));
		}
		return result;
    }
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(15, 18));
		list.add(new Interval(8, 10));
		System.out.println(merge(list));
	}

}
