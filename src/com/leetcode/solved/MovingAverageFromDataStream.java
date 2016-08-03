package com.leetcode.solved;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
	Queue<Integer> queue;
    int size = 0;
    double curSum = 0;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
        this.curSum = 0;
    }
    
    public double next(int val) {
        if(queue.size() == this.size){
            curSum -= queue.poll();
        }
        curSum += val;
        queue.add(val);
        return curSum/queue.size();
    }
}
