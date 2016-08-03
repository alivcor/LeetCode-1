package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueWordAbbreviation {

	Map<String,HashSet<String>> abDict;
    public UniqueWordAbbreviation(String[] dictionary) {
        abDict = new HashMap();
        for(String s : dictionary){
            if(s == null) continue;
            String abbr = s;
            if(s.length() > 2) abbr = "" + s.charAt(0) + (s.length()-2) + s.charAt(s.length()-1);
            
            if(!abDict.containsKey(abbr)) abDict.put(abbr,new HashSet<String>());
            abDict.get(abbr).add(s);
        }
    }

    public boolean isUnique(String s) {
        if(s == null) return false;
        String abbr = s;
        if(s.length() > 2) abbr = "" + s.charAt(0) + (s.length()-2) + s.charAt(s.length()-1);
        
        return !abDict.containsKey(abbr) || (abDict.get(abbr).contains(s) && abDict.get(abbr).size() == 1);    
    }
}
