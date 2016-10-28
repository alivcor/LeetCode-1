package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;


public class CombinationSumIII {

	public static List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> list = new ArrayList<>();
		int[] store = new int[k];
		combinationSum3(k, n, store, list);
		return list;
	}
	/*
	 * This function uses backtracking to find all possible combinations.
	 * If at a given point both k and n are zero.
	 * We have reached the desired result, add this into the List.
	 * 
	 * But if any one of them becomes zero. Return, as we won't be able to achieve the result using this combination.
	 * 
	 * Inorder to keep things in Ascending order, we will start filling the array from last element to first.
	 * We define Start as the max possible value, which would be N - (k(k-1)/2). 
	 * Considering that the minimum values (1,2,3..) fill up the other elements in list.
	 * 
	 * We will traverse from N to 1 recursing at every point reducing K by 1 and N by the integer included.
	 */
	public static void combinationSum3(int k, int n,int[] store,List<List<Integer>> list) {
        if(k == 0 && n == 0) {
        	List<Integer> temp = new ArrayList<>();
        	for(int i = 0; i < store.length; i++){
        		temp.add(store[i]);
        	}
        	list.add(temp);
        }
        
        if(k == 0 || n == 0) return;
        
        int start = n - (k*(k-1)/2);
        if(start > 9) start = 9;
        if(k + 1 <= store.length)
        	start = store[k] - 1;
        for(int i = start; i > 0;i--){
        	store[k-1] = i;
        	combinationSum3(k-1, n-i, store,list);
        }
		return;
    }
	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 10));

	}

}
