package com.leetcode.solved;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if(num == null) return true;
        
        for(int fIndex = 0, bIndex = num.length()-1; fIndex <= bIndex; fIndex++,bIndex--){
            if(num.charAt(fIndex) == '8' && num.charAt(bIndex) == '8') continue;
            if(num.charAt(fIndex) == '6' && num.charAt(bIndex) == '9') continue;
            if(num.charAt(fIndex) == '9' && num.charAt(bIndex) == '6') continue;
            if(num.charAt(fIndex) == '1' && num.charAt(bIndex) == '1') continue;
            if(num.charAt(fIndex) == '0' && num.charAt(bIndex) == '0') continue;
            return false;
        }
       return true; 
    }
    
}
