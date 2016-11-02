package com.leetcode.solved;

import java.util.Arrays;

public class ID435_NonOverlappingIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null) return 0;
        Arrays.sort(intervals, (a,b) -> {
            int start = Integer.compare(a.start, b.start);
            if(start == 0) start = Integer.compare(a.end, b.end);
            return start;
        });
        
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                //if start of current is less than end of previous, we will remove the one with larger end time
                count++;
                intervals[i].end = Math.min(intervals[i].end, intervals[i-1].end);
            }
        }
        return count;
    }

}
