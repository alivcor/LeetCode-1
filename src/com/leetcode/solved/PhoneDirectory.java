package com.leetcode.solved;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    Set<Integer> directory;
    int curPointer = -1;
    int curMax;
    public PhoneDirectory(int maxNumbers) {
        this.directory = new HashSet<Integer>();
        this.curMax = maxNumbers-1;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(this.directory.size() == 0 && this.curPointer >= this.curMax) return -1;
        if(this.curPointer < this.curMax) return ++this.curPointer;
    
        Iterator<Integer> iterator = this.directory.iterator(); 
        int freeNum = iterator.next();
        iterator.remove();
        return freeNum;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
         return ((number > curPointer && number <= this.curMax) || directory.contains(number));
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(number > this.curPointer) return;
        this.directory.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */