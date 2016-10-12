package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump {
	
	public static boolean canCross1(int[] stones, int index, int prev) {
        if(prev <= 0 && index > 0) return false;
		if(index == stones.length - 1) return true;
        
		boolean result = false;
		int target = index + 1;
		while(!result && target < stones.length && stones[target] - stones[index] <= prev + 1){
			if(!result && stones[target] - stones[index] == prev - 1){
				result = canCross1(stones, target, prev - 1);
			}
			if(!result && stones[target] - stones[index] == prev){
				result = canCross1(stones, target, prev);
			}
			if(!result && stones[target] - stones[index] == prev + 1){
				result = canCross1(stones, target, prev + 1);
			}
			target += 1;
		}
		
		return result;
    }
	
	public static boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return true; 
		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for(int i = 0; i < stones.length; i++) map.put(stones[i],new HashSet<Integer>());
		
		map.get(stones[0]).add(1);
		
		for(int i = 0; i < stones.length; i++){
			int curS = stones[i];
			for(int step : map.get(curS)){
				int reach = step + curS;
				if(reach == stones[stones.length - 1]) return true;
				if(!map.containsKey(reach)) continue;
				map.get(reach).add(step);
				map.get(reach).add(step+1);
				if(step - 1 > 0) map.get(reach).add(step - 1);
			}
		}
		
		return false;
    }

	public static void main(String[] args) {
		System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));

	}

}
