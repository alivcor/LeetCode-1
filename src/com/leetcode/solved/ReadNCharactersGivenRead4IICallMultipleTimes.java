package com.leetcode.solved;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersGivenRead4IICallMultipleTimes {
	Queue<Character> buffer = new LinkedList<>();
    int countP = 0;
    public int read(char[] buf, int n) {
        int curCount = 0;
        while(!buffer.isEmpty() && curCount < n) buf[curCount++] = buffer.poll();
        
        if(curCount == n) return n;
        int prevCallCount = 4;
        char[] temp = new char[4];
        while(curCount < n && prevCallCount == 4){
            prevCallCount = read4(temp);
            int indextemp = 0;
            while(indextemp < prevCallCount && curCount < n) buf[curCount++] = temp[indextemp++];
            while(indextemp < prevCallCount) buffer.add(temp[indextemp++]);
        }
        return curCount;
        
    }
}
