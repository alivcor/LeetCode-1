package com.leetcode.solved;

import java.util.List;

	 
public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for(NestedInteger curInt : nestedList){
            sum += depthSum(curInt,1);
        }
        return sum;
    }
    
    private int depthSum(NestedInteger nestInt, int level){
        if(nestInt.isInteger()) return level*nestInt.getInteger();
        int sum = 0;
        for(int i = 0; i < nestInt.getList().size(); i++){
            sum += depthSum(nestInt.getList().get(i),level+1);
        }
        return sum;
    }
}
