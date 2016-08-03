package com.leetcode.solved;

import java.util.List;

interface NestedInteger {
	 public boolean isInteger();
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	 
public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        int depth = 1;
        int sum = 0;
        for(NestedInteger nInt : nestedList){
            sum += depthSum(nInt,1);
        }
        return sum;
    }
    
    private int depthSum(NestedInteger val, int depth){
        if(val.isInteger()) return depth*val.getInteger();
        int sum = 0;
        for(NestedInteger nInt : val.getList()){
            sum += depthSum(nInt,depth+1);
        }
        return sum;
    }

}
