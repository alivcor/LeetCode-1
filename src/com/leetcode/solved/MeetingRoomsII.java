package com.leetcode.solved;

import java.util.Arrays;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int maxVal = 0;
        int curCount = 0;
    
        int sIndex = 0;
        int eIndex = 0;
        while(sIndex < intervals.length){
            if(start[sIndex] < end[eIndex]){
                sIndex++;
                curCount++;
                maxVal = Math.max(curCount, maxVal);
            }else if(start[sIndex] > end[eIndex]){
                eIndex++;
                curCount--;
            }else{
                sIndex++;
                eIndex++;
            }
        }
        return maxVal;
    }

}
