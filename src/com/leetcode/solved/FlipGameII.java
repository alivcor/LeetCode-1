package com.leetcode.solved;

public class FlipGameII {
	public boolean canWin(String s) {
        if(s == null) return true;
        return canWin(s.toCharArray());
    }
    
    private boolean canWin(char[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == '+' && array[i+1] == '+'){
                array[i] = array[i+1] = '-';
                boolean winOpponent = canWin(array);
                array[i] = array[i+1] = '+';
                if(!winOpponent) return true;
            }
        }
        
        return false;
    }

}
