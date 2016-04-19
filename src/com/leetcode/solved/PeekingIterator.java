package com.leetcode.solved;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator;
	Integer nextElement = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
	    if(iterator.hasNext()){
	    	nextElement = iterator.next();
	    }
	    
	}
	
	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElement;
	}
	
	@Override
	public boolean hasNext() {
		return !(nextElement == null);
		
	}

	@Override
	public Integer next() {
		Integer result = nextElement;
		if(iterator.hasNext()){
			nextElement = iterator.next();
		}else{
			nextElement = null;
		}
		return result;
	}

}
