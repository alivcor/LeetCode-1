package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
        List<String> prev2 = new ArrayList<String>();
        prev2.add("0");
        prev2.add("1");
        prev2.add("8");
        List<String> prev1 = new ArrayList<String>();
        prev1.add("11");
        prev1.add("69");
        prev1.add("88");
        prev1.add("96");
        Map<Integer,List<String>> map = new HashMap<>();
        map.put(1,prev2);
        map.put(2,prev1);
        
        if(n <= 2) return map.get(n);
        map.get(2).add(0,"00");
        for(int i = 3; i <= n; i++){
            map.put(i,append(map.get(i-2)));
            map.remove(i-2);
        }
        
        List<String> result = new ArrayList<String>();
        for(String s : map.get(n)){
            if(s.charAt(0) == '0') continue;
            result.add(s);
        }
        return result;
    }
    
    private static List<String> append(List<String> prev){
        List<String> result = new ArrayList<>();
        for(String cur : prev){
            result.add("0" + cur + "0");
            result.add("1" + cur + "1");
            result.add("6" + cur + "9");
            result.add("8" + cur + "8");
            result.add("9" + cur + "6");
        }
        Collections.sort(result);
        return result;
    }

}
