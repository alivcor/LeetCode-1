package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		if(k <= 0 || n <= 0) return list;
		int array[] = new int[k];
		combine(1, n, k, array, list);
		
		return list;
    }
	
	/** A simple backtracking solution.
	 * Keep a count of the already added element in the array.
	 * Add the whole set to list, once we reach the count.
	 * @param start
	 * @param n
	 * @param k
	 * @param array
	 * @param list
	 */
	public static void combine(int start, int n, int k,
			int array[], List<List<Integer>> list){
		if(k == 0){
			List<Integer> arrayL = new ArrayList<Integer>();
			for(int i = 0; i < array.length; i++){
				arrayL.add(array[i]);
			}
			System.out.println(arrayL);
			list.add(arrayL);
			return;
		}
		
		for(int i = start; i <= n; i++){
			array[array.length-k] = i;
			combine(i+1,n, k-1,array, list);
		}
	}
	public static void main(String[] args) {
		System.out.println(combine(4, 2));

	}

}
