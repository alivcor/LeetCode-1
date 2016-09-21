package com.leetcode.solved;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {
	
	Iterator<Integer> itr;
    int index;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        index = 0;
        if(vec2d == null || vec2d.size() == 0) itr = null;
        else itr = vec2d.get(index).iterator();
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        if(itr == null) return false;
        while(!itr.hasNext() && index < vec2d.size() - 1) itr = vec2d.get(++index).iterator();
        if(index == vec2d.size() || !itr.hasNext()) return false;
        return true;
    }

}
