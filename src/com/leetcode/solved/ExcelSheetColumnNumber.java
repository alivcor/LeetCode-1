package com.leetcode.solved;

public class ExcelSheetColumnNumber {

	private static int power(int val, int pow){
		int prod = 1;
		while(pow > 0){
			prod = prod * val;
			pow--;
		}
		
		return prod;
	}
	
	public static int titleToNumber(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        if(s.length() == 1) {
        	if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'){
        		return s.charAt(0) - 'A' + 1;
        	}
        }
        
        return (power(26, s.length()-1)*(s.charAt(0) - 'A' + 1) + titleToNumber(s.substring(1))); 
        
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("AAA"));
		System.out.println(titleToNumber("BA"));

	}

}
