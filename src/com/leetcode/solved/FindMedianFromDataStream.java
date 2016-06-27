package com.leetcode.solved;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a.compareTo(b)); //Top min element(have max values)
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a)); //top would be max element(min vals) 
    public void addNum(int num) {
    	if(maxHeap.size() == 0){
    		maxHeap.add(num);
    		return;
    	}
    	if(num > maxHeap.peek()){
    		//Num is greater than the max val available in this heap.
    		minHeap.add(num);
    	}else{
    		maxHeap.add(num);
    	}
        if(minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll()); 
        else if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.poll());
        return;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) return (minHeap.peek() + maxHeap.peek())*1.0/2;
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        return maxHeap.peek();
    }
    
    public static void main(String[] args){
    	
    	FindMedianFromDataStream mf = new FindMedianFromDataStream();
    	mf.addNum(-1);
    	System.out.println(mf.findMedian());
    	mf.addNum(-2);
    	System.out.println(mf.findMedian());
    	mf.addNum(-3);
    	System.out.println(mf.findMedian());
    	mf.addNum(-4);
    	System.out.println(mf.findMedian());
    	mf.addNum(-5);
    	System.out.println(mf.findMedian());
    	
    }
};

// Your MedianFinder object will be instantiated and called as such:
 