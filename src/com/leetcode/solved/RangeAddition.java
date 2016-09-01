package com.leetcode.solved;

public class RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
        if(length == 0) return new int[length];
        int[] result = new int[length];
        for(int i = 0; i < updates.length; i++){
            result[updates[i][0]] += updates[i][2];
            if(updates[i][1] < result.length-1) result[updates[i][1]+1] -= updates[i][2];
        }
        
        for(int i = 1; i < result.length; i++){
            result[i] += result[i-1];
        }
        
        return result;
    }

}
