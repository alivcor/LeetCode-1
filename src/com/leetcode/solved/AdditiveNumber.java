package com.leetcode.solved;


public class AdditiveNumber {
	
	public static boolean isAdditiveNumber(String num) {
		if(num == null || num.length() < 3) return false;
		int length = num.length();
		
		for(int i = 1; i <=(length-1)/2; i++){
			if(num.charAt(0) == '0' && i > 1) break;
			
			for(int j = i + 1; length-j>=j-i && length-j>=i; j++){
				if(num.charAt(i) == '0' && j-i > 1) break;
				long a = Long.parseLong(num.substring(0,i));
				long b = Long.parseLong(num.substring(i,j));
				String rest = num.substring(j); 
				if(isAdd(rest,a ,b))return true;
			}
		}
		return false;
    }

	private static boolean isAdd(String value, long a, long b){
		if(value.length() == 0) return true;
		long sum = a + b;
		return (value.startsWith(String.valueOf(sum)) && isAdd(value.substring(String.valueOf(sum).length()), b, sum));
	}
	
	public static void main(String[] args) {
		System.out.println(isAdditiveNumber("121474836472147483648"));

	}

}
