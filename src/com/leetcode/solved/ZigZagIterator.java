package com.leetcode.solved;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigZagIterator {
	LinkedList<Iterator> listItr;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        listItr = new LinkedList<Iterator>();
        if(v1 != null && v1.size() > 0) listItr.add(v1.iterator());
        if(v2 != null && v2.size() > 0) listItr.add(v2.iterator());
    }

    public int next() {
        Iterator top = listItr.remove();
        int value = (Integer)top.next();
        if(top.hasNext()) listItr.add(top);
        return value;
    }

    public boolean hasNext() {
        return !listItr.isEmpty();
    }

}
