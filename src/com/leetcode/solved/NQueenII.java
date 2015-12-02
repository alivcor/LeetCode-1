package com.leetcode.solved;

public class NQueenII {
	
	private static boolean isSafe(int positions[], int index){
		
		for(int i = 0; i < index; i++){
			if(positions[i] == positions[index])
				return false;
			if(absVal(positions[i] - positions[index]) == absVal(i - index))
				return false;
		}
		
		return true;
	}
	private static int absVal(int i) {
		return (i >= 0) ? i : -1*i;
	}
	public static int totalNQueens(int n) {
        
		if(n == 0 || n == 1) return 0;
		int positions[] = new int[n];
		
		int count = 0;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				positions[i] = j;
				if(isSafe(positions, i)){
					break;
				}
			}
		}
		
		return count;
    }

	public static void main(String[] args) {
		System.out.println(totalNQueens(4));

	}

}
