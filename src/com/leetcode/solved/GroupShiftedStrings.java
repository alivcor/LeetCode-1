package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	private String convert(String val){
        if(val == null) return val;
        char[] array = val.toCharArray();
        int move = array[0] - 'a';
        
        for(int i = 0; i < array.length; i++){
            int curMove = array[i] - move; 
            if(curMove < 97) curMove += 26;
            array[i] = (char)(curMove);
        }
        
        return String.valueOf(array);
    }
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String convert = convert(s);
            if(!map.containsKey(convert)) map.put(convert, new ArrayList<String>());
            map.get(convert).add(s);
        }
        
        return new ArrayList<>(map.values());
        
    }

}
