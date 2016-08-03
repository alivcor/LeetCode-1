package com.leetcode.solved;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        if(k == 1) return matrix[0][0];
        if(k >= matrix.length*matrix.length) return matrix[matrix.length-1][matrix[0].length-1];
        
        
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) return 1;
				if(o1[0] < o2[0]) return -1;
				return 0;
			}
		});
		
		for(int i = 0; i < matrix.length; i++) queue.add(new int[]{matrix[i][0],i,0});
		while(k > 1){
		    int[] top = queue.poll();
		    System.out.println(top[0]);
		    if(top[2] < matrix[0].length-1)
		        queue.add(new int[]{matrix[top[1]][top[2]+1], top[1],top[2] + 1});
		    k--;
		}
        int[] top = queue.poll();		
		return matrix[top[1]][top[2]];
    }
	

}
