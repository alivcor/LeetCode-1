package com.leetcode.solved;

public class StringToIntegerATOI {
	public static boolean isSign(char c){
		if(c == '-' || c == '+') return true;
		return false;
	}
	
	public static boolean isDigit(char c){
		if(c >= '0' && c <= '9') return true;
		return false;
	}

	public static int myAtoi(String str){
		if(str == null || str.length() == 0) return 0;
		
		str = str.trim();
		
		if(
				(str.length() == 1 && isSign(str.charAt(0))) ||
				(str.length() >=2 && isSign(str.charAt(0)) && isSign(str.charAt(1)))
				)
			return 0;
		
		
		
		int sign = 1;
		str = str.replace("+", "");
		while(str.charAt(0) == '-') {
			sign = sign*-1;
			str = str.substring(1);
		}
		
		int value = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				if(sign == 1 && value > (Integer.MAX_VALUE - (str.charAt(i) - '0'))/10)
					return Integer.MAX_VALUE;
				if(sign == -1 && value  < (Integer.MIN_VALUE + (str.charAt(i) - '0'))/10) return Integer.MIN_VALUE;
				value = value*10 + sign*(str.charAt(i) - '0');
			}else{
				return value;
			}
		}
		
		return value;
	}

}
