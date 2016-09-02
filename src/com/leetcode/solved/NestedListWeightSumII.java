package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeightSumII {
	public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(NestedInteger curInt : nestedList){
            depthSum(curInt,map,1);
        }
        
        int maxkey = 0;
        for(int key : map.keySet()) maxkey = Integer.max(maxkey,key);
        int sum = 0;
        for(int key : map.keySet()){
            for(int val : map.get(key)){
                sum += (maxkey - key + 1)*val;
            }
        }
        return sum;
    }
    private void depthSum(NestedInteger nestInt, Map<Integer,List<Integer>> map, int level){
        if(nestInt.isInteger()){
            if(!map.containsKey(level)) map.put(level, new ArrayList<Integer>());
            map.get(level).add(nestInt.getInteger());
        }
        
        for(NestedInteger curInt : nestInt.getList()){
            depthSum(curInt,map,level+1);
        }
        return;
    }
}
