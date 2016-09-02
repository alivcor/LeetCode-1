package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {
	Map<String,List<Integer>> indexMap;
    public ShortestWordDistance2(String[] words) {
        indexMap  = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!indexMap.containsKey(words[i])) indexMap.put(words[i],new ArrayList<>());
            indexMap.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> listW1 = this.indexMap.get(word1);
        List<Integer> listW2 = this.indexMap.get(word2);
        
        int i1 = 0;
        int i2 = 0;
        int minCount = Integer.MAX_VALUE;
        while(i1 < listW1.size() && i2 < listW2.size()){
            minCount = Integer.min(minCount, Math.abs(listW1.get(i1) - listW2.get(i2)));
            if(listW1.get(i1) > listW2.get(i2)) i2++;
            else i1++;
        }
        return minCount;
    }
}
