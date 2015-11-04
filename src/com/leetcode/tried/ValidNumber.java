package com.leetcode.tried;
/*
 * https://leetcode.com/problems/valid-number/
 * Validate if a given String is numeric.
 */

public class ValidNumber {
	
	public static boolean isNumber(String s) {
        
		s = s.trim();
        boolean hasDecimal = false;
        boolean hasPower = false;
        
        if(s.length() == 0) return false;
        if (s.charAt(0) == '-' ||s.charAt(0) == '+')
        	s = s.substring(1);
        if(s.length() == 1 && ((s.charAt(0) == '.')||(s.charAt(0) == 'e')||(s.charAt(0) == '-'))) return false;
        
        if(s.startsWith(".e") || s.endsWith(".e") ||
        		s.contains("e.")) return false;
        
        
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '.'){
        		if (hasDecimal) return false;
        		hasDecimal = true;
        	}else if(s.charAt(i) == 'e'){
        		if(i == 0 || i == s.length()-1 || hasPower) return false;
        		hasPower = true;
        	}else if(s.charAt(i) < '0' || s.charAt(i) > '9')
        		return false;
        }
        
        return true;
        
    }
	public static void main(String[] args) {
		/*Integer
		 * Float
		 * Power
		 * 
		 */

	}

}
