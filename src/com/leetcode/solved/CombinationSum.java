package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
	
	public static void combinationSum(int[] candidates, int target,
			List<List<Integer>> result, int res[], int index,int indexRes) {
        
        if(candidates == null || index == candidates.length) return;
        
        if(candidates.length == 0 && target != 0) return;
        
        if(target == 0){
        	List<Integer> row = new ArrayList<>();
        	for(int i = 0; i < indexRes; i++){
        		row.add(res[i]);
        	}
        	result.add(row);
        	
        }
        if(candidates[index] <= target){
        	res[indexRes] = candidates[index];
        	combinationSum(candidates, target-candidates[index], result,res,index,indexRes+1);
        	combinationSum(candidates, target, result,res,index+1,indexRes);
        	
        }
        
    }
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Integer[] arr = new Integer[candidates.length];
		for(int i = 0 ; i < candidates.length; i++){
			arr[i] = candidates[i];
		}
		List<Integer> listCand = Arrays.asList(arr); 
		Collections.sort(listCand);
		for(int i = 0; i < listCand.size();i++){
			candidates[i] = listCand.get(i);
		}
		List<List<Integer>> result = new ArrayList<>();
		int res[] = new int[100000];
		
		combinationSum(candidates, target,result,res,0,0);
		return result;
	}

	public static void main(String[] args) {
		int candidates[] = {2,3,6,7};
		combinationSum(candidates, 7);

	}

}
