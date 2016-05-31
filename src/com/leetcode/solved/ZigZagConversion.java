package com.leetcode.solved;

import java.util.stream.IntStream;

public class ZigZagConversion {
	
	public static String convert(String s, int numRows) {
		if(numRows <= 1) return s;
		StringBuilder[] sbArray = new StringBuilder[numRows];
		for(int i = 0; i < sbArray.length; i++) sbArray[i] = new StringBuilder();
		
		int index = 0;
		while(index < s.length()){
			//Zig
			for(int i = 0; i < numRows && index < s.length(); i++){
				sbArray[i].append(s.charAt(index++));
			}
			//Zag
			for(int i = numRows-2; i > 0 && index < s.length(); i--){
				sbArray[i].append(s.charAt(index++));
			}
		}
		
		IntStream.range(1, sbArray.length).forEach(i -> sbArray[0].append(sbArray[i]));
		return sbArray[0].toString();
    }

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("ABCDE", 4));

	}

}
