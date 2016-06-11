package com.leetcode.solved;

import java.util.Arrays;

public class MaximumGap {
	public static class Pair{
		Integer min;
		Integer max;
		@Override
		public String toString() {
			return "Pair [min=" + min + ", max=" + max + "]";
		}
		public Pair(Integer min, Integer max) {
			super();
			this.min = min;
			this.max = max;
		}
		
	}
	public static int maximumGap(int[] nums){
		if(nums == null || nums.length < 2) return 0;
		int max = Arrays.stream(nums).max().getAsInt();
		int min = Arrays.stream(nums).min().getAsInt();
		
		Pair[] bucket = new Pair[nums.length+1];
		double ratio = (max - min)/(1.0*nums.length);
		for(int i = 0; i < nums.length;i++){
			int bukInd = (int) ((nums[i] - min)/ratio);
			if(bucket[bukInd] == null){
				bucket[bukInd] = new Pair(nums[i], nums[i]);
			}else{
				bucket[bukInd].min = Integer.min(bucket[bukInd].min, nums[i]);
				bucket[bukInd].max = Integer.max(bucket[bukInd].max, nums[i]);
			}
		}
		
		int maxgap = 0;
		Integer prev = null;
		
		for(int i = 0; i < bucket.length; i++){
			
			if(bucket[i] != null){
				if(prev != null){
					maxgap = Integer.max(maxgap, Integer.max(bucket[i].max - bucket[i].min, bucket[i].min - prev));
					prev = bucket[i].max;
				}else{
					prev = bucket[i].max;
				}
			}
		}
		return maxgap;
	}


}
