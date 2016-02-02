package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || target == 0) return Collections.emptyList();
        Arrays.sort(candidates);
        Set<String>  listVals = new HashSet<>();
        int[] array = new int[candidates.length];
        combSum(candidates, 0, array, 0, target, listVals);
        
        List<List<Integer>> result = new ArrayList<>();
        for(String s : listVals){
        	result.add(convStringToList(s.split(" ")));
        }
        
        return result;
    }
    
	private static List<Integer> convStringToList(String[] array){
		List<Integer> list = new ArrayList<>();
		for(String s : array){
			list.add(Integer.parseInt(s));
		}
		
		return list;
	}
    private static String copyArrayToList(int array[], int index){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < index; i++){
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }
    private static void combSum(int[] candidates, int index, int array[], int aindex, int target, Set<String> list){
        
        if(target <  0) return;
        if(target == 0){
            list.add(copyArrayToList(array,aindex));
            return;
        }
        if( candidates.length == index) return;
        combSum(candidates, index + 1, array, aindex, target, list);
        array[aindex] = candidates[index];
        combSum(candidates, index + 1, array, aindex + 1, target - array[aindex], list);
        
    }

	public static void main(String[] args) {
		int array[] = {1};//{10,1,2,7,6,1,5};
		System.out.println(combinationSum2(array, 1));

	}

}
