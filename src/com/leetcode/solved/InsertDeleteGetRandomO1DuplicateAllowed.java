package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1DuplicateAllowed {

    /** Initialize your data structure here. */
    Map<Integer,Set<Integer>> map;
    List<Integer> list;
    Random rand = new Random();
    public InsertDeleteGetRandomO1DuplicateAllowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) map.put(val,new HashSet<Integer>());
        map.get(val).add(list.size());
        list.add(val);
        System.out.println("Insert:" + val);
        System.out.println(map);
        return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if(index < list.size() - 1){
            int last = list.get(list.size() - 1);
            list.set(index,last);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(index);
        }
        
        list.remove(list.size() - 1);
        if(map.get(val).size() == 0) map.remove(val);
        System.out.println("Remove:" + val);
        System.out.println(map);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */