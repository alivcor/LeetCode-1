package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
	List<String> result = new ArrayList<String>();
    public List<String> generateAbbreviations(String word) {
        generate(word, "", 0, 0);
        return result;
    }
    
    private void generate(String word, String current, int index, int count){
        if(index == word.length()){
            if(count > 0) result.add(current + count);
            else result.add(current);
            return;
        }
        
        generate(word, current, index + 1, count + 1);
        generate(word, current + ((count > 0) ? count : "") + word.charAt(index), index+1, 0);
    }
}
