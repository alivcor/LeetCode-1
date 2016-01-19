package com.leetcode.solved;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HIndex {

	/**The main question is to compute the maximum count where all element are
	 * greater than or equal to count.
	 * 
	 * We add all the elements to Max Priority Queue and keep on popping element
	 * until the next element is less than count.
	 * @param citations
	 * @return
	 */
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 > o2) ? -1 : 1;
			}
		});
        
        for(int i = 0; i < citations.length; i++)
        	queue.add(citations[i]);
        
        int count = 1;
        while(!queue.isEmpty() && (queue.poll() >= count)){
        	count++;
        }
        
        return count - 1;
    }
	public static void main(String[] args) {
		int[] array = {3,0,6,1,5};
		System.out.println(hIndex(array));
		

	}

}
