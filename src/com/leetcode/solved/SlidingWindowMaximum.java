package com.leetcode.solved;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class SlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null) return null;
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deqInt = new LinkedList<>();
		
		for(int i = 0; i < nums.length; i++){
			if(i-k >= 0){
				result[i-k] = nums[deqInt.getFirst()];
				if(deqInt.getFirst() == i-k) deqInt.removeFirst();
			}
			while(!deqInt.isEmpty() && nums[deqInt.getLast()] < nums[i]) deqInt.removeLast();
			deqInt.addLast(i);
		}
		result[result.length - 1] = nums[deqInt.getFirst()];
		return result;
    }
	public static void main(String[] args) {
		int nums[] = {1,3,-1,-3,5,3,6,7};
		nums = maxSlidingWindow(nums, 3);
		Arrays.stream(nums).forEach(System.out::println);

	}

}
