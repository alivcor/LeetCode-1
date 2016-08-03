package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> listStates = new ArrayList<String>();
        if(s == null || s.length() <=1) return listStates;
        
        int index = 1;
        char[] array = s.toCharArray();
        while(index < array.length){
            if(array[index] == '-') index++;
            else if(array[index-1] == '+'){
                array[index-1] = array[index] = '-';
                listStates.add(String.valueOf(array));
                array[index-1] = array[index] = '+';
            }
            index++;
        }
        return listStates;
    }
}
