package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
	
	private static List<String> getPrintQueens(int result[]){
		
		if(result == null || result.length == 0) return Collections.emptyList();
		List<String> printResult = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < result.length; i++) sb.append('.');
		for(int i = 0; i < result.length; i++){
			sb.setCharAt(result[i], 'Q');
			printResult.add(sb.toString());
			sb.setCharAt(result[i], '.');
		}
		
		return printResult;
	}
	
	private static boolean isSafe(int[] result, int index){
		for(int i = 0; i < index; i++){
			if(result[i] == result[index]) return false;
			if(Math.abs(result[i] - result[index]) == Math.abs(i - index)) return false;
		}
		return true;
	}
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> output = new ArrayList<>();
		nqueenUtil(new int[n], 0, output);
		return output;
    }
	
	private static void nqueenUtil(int result[], int index, List<List<String>> output){
		if(index == result.length){
			output.add(getPrintQueens(result));
			return;
		}
		for(int i = 0; i < result.length; i++){
			result[index] = i;
			if(isSafe(result, index)){
				nqueenUtil(result, index + 1, output);
			}
			result[index] = 0;
		}
		
		return;
	}

	public static void main(String[] args) {
		System.out.println(solveNQueens(4));

	}

}
