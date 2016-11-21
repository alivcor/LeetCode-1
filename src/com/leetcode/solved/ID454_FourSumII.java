package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class ID454_FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	    
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j],0) + 1);
            }
        }
        
        int count = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int target = 0 - A[i] - B[j];
                if(map.containsKey(target)) count += map.get(target);
            }
        }
        
        return count;
    }

}
