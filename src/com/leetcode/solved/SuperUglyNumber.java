package com.leetcode.solved;

import java.util.PriorityQueue;

public class SuperUglyNumber {
	
	private static class Pair{
		Integer value;
		Integer index;
		public Pair(Integer value, Integer index) {
			super();
			this.value = value;
			this.index = index;
		}
		
	}
	public static int nthSuperUglyNumber(int n, int[] primes) {
		if(n == 0) return 0;
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b) -> ((a.value).compareTo(b.value)));
		
		int[] index = new int[primes.length];
		int[] result = new int[n];
		result[0] = 1;
		for(int i = 0; i < primes.length; i++){
			queue.add(new Pair(primes[i],i));
		}
		for(int i = 1; i < n; i++){
			Pair top = queue.poll();
			index[top.index] += 1;
			result[i] = top.value;
			queue.add(new Pair(result[index[top.index]] * primes[top.index], top.index));
			if(result[i] == result[i-1]) i--;
		}
		return result[n-1];
    }

	public static void main(String[] args) {
		int[] primes = {2,7,13,19};
		System.out.println(nthSuperUglyNumber(12, primes));

	}

}
