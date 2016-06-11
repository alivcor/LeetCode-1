package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class DataStreamAsDisjointIntervals {

    
	public static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
			@Override
			public String toString() {
				return "Interval [start=" + start + ", end=" + end + "]";
			}
		      
	}
	   
	TreeMap<Integer, Interval> trmap;
	public DataStreamAsDisjointIntervals() {
    	trmap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(trmap.containsKey(val)) return;
    	Integer loKey = trmap.lowerKey(val);
    	Integer hiKey = trmap.higherKey(val);
    	if(loKey != null && hiKey != null && trmap.get(loKey).end == val -1 && hiKey == val + 1){
    		int newEnd = trmap.get(hiKey).end;
    		trmap.remove(hiKey);
    		trmap.get(loKey).end = newEnd;
    	}
    	else if(loKey != null &&  trmap.get(loKey).end >= val-1){
    		trmap.get(loKey).end = Math.max(val,trmap.get(loKey).end);
        }else if(hiKey != null && hiKey == val+1 ){
           trmap.put(val,new Interval(val,trmap.get(hiKey).end));
           trmap.remove(hiKey);
        }else trmap.put(val,new Interval(val,val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(trmap.values());
    }
	    
	    public static void main(String[] args){
	    	DataStreamAsDisjointIntervals obj = new DataStreamAsDisjointIntervals();
	    	 obj.addNum(1);
	    	 obj.addNum(3);
	    	 obj.addNum(7);
	    	 obj.addNum(2);
	    	 obj.addNum(6);
	    	 List<Interval> param_2 = obj.getIntervals();
	    	 System.out.println(param_2);
	    }
	}

