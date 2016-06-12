package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start > o2.start) return 1;
				if(o1.start < o2.start) return -1;
				return 0; 
			}
		});	
		List<Interval> result = new ArrayList<Interval>();
		result.add(intervals.get(0));
		int resultIndex = 0;
		for(int i = 1; i < intervals.size(); i++){
			if(result.get(resultIndex).end >= intervals.get(i).start){
				result.get(resultIndex).end = Integer.max(result.get(resultIndex).end, intervals.get(i).end);
			}else{
				result.add(intervals.get(i));
				resultIndex++;
			}
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
