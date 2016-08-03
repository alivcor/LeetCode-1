package com.leetcode.solved;

public class ValidNumber {
	public boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numAfE = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numSeen = true;
                numAfE = true;
            }else if(s.charAt(i) == '.'){
                if(dotSeen || eSeen) return false;
                dotSeen = true;
            }else if(s.charAt(i) == 'e'){
                if(eSeen || !numAfE) return false;
                eSeen = true;
                numAfE = false;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else return false;
        }
        return numSeen && numAfE;
    }
}
