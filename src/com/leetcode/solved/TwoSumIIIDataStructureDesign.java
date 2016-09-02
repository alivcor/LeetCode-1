package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDataStructureDesign {
	// Add the number to an internal data structure.
    Map<Integer,Integer> mapCount = new HashMap<>();
	public void add(int number) {
	    if(mapCount.containsKey(number)) mapCount.put(number,2);
	    else mapCount.put(number,1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer key : mapCount.keySet()){
	        if(value - key == key && mapCount.get(key) == 2) return true;
	        if(value - key != key && mapCount.containsKey(value-key)) return true;
	    }
	    return false;
	}
}
