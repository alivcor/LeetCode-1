package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class LongestAbsoluteFilePath {
public int lengthLongestPath(String input) {
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int maxLen = 0;
        for(String line : input.split("\n")){
            System.out.println(line);
            String name = line.replaceAll("^\\t+", "");
            Integer depth = line.length() - name.length();
            if(name.indexOf(".") != -1){
                maxLen = Integer.max(maxLen,map.get(depth) + name.length());
            }else{
                map.put(depth+1, map.get(depth) + 1 + name.length());
            }
        }
        
        return maxLen;
        
        
    }

}
