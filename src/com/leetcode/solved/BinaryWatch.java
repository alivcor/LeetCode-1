package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {
	
	private static Map<Integer, List<String>> buildCache(int n){
		Map<Integer, List<String>> map = new HashMap<>();
		
		for(int i = 0; i <= n; i++){
			int count = countBits(i);
			if(!map.containsKey(count)) map.put(count, new ArrayList<>());
			map.get(count).add(((i < 10) ? "0" : "" )+ i);
		}
		
		return map;
	}
	
	private static int countBits(int n){
		int count = 0;
		while(n > 0){
			n = n&(n-1);
			count++;
		}
		return count;
	}
	public static List<String> readBinaryWatch(int num) {
        Map<Integer, List<String>> map = buildCache(60);
        List<String> result = new ArrayList<>();
        
        for(int i = Math.max(0, num - 5); i <= Math.min(3, num); i++){
        	List<String> hours = map.get(i);
        	List<String> minutes = map.get(num - i);
        	result.addAll(appendVal(hours, minutes));
        }
        
        return result;
    }
	
	private static List<String> appendVal(List<String> hours, List<String> minutes){
		List<String> result = new ArrayList<>();
		for(String hr : hours){
			if(Integer.valueOf(hr) > 12) return result;
			for(String mins : minutes){
				result.add(hr + ":" + mins);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(readBinaryWatch(6));

	}

}
