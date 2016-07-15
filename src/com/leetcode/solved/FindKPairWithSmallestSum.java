package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairWithSmallestSum {
	private static class Data{
		int i; 
		int j;
		int sum;
		public Data(int i, int j, int sum) {
			super();
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
		@Override
		public String toString() {
			return "Data [i=" + i + ", j=" + j + ", sum=" + sum + "]";
		}
		
		
	}
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return Collections.emptyList();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Data> queue = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.sum - o2.sum;
			}
		});
        
        queue.add(new Data(0, 0, nums1[0] + nums2[0]));
        while(result.size() < k && !queue.isEmpty()){
        	Data top = queue.poll();
        	result.add(new int[]{nums1[top.i], nums2[top.j]});
        	if(top.i < nums1.length-1) queue.add(new Data(top.i + 1, top.j, nums1[top.i+1] + nums2[top.j]));
        	if(top.i == 0 && top.j < nums2.length - 1) queue.add(new Data(top.i, top.j+1, nums1[top.i] + nums2[top.j+1]));
        }        
        return result;
    }

}
