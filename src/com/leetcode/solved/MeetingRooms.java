package com.leetcode.solved;

import java.util.Arrays;
import java.util.Comparator;


public class MeetingRooms {
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
	public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) return true;
        
        Arrays.sort(intervals,new Comparator<Interval>() {
                     public int compare(Interval s1,Interval s2) {
                           if(s1.start < s2.start) return -1;
                           if(s2.start < s1.start) return 1;
                           if(s1.end < s2.end) return -1;
                           return 1;
                      }
    });
    
    for(int i = 1; i < intervals.length; i++)
        if(intervals[i-1].end > intervals[i].start) return false;
    
    return true;
    }
}
