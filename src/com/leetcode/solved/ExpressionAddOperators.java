package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	
	public static List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		addOperators(num, target, 0, "", 0, 1, result);
		return result;
    }

	private static void addOperators(String num, int target, int index, String currStr, long curVal,long mult, List<String> result){
		if(num.length() == index){
			if(curVal == target) result.add(currStr);
				return;
		}
		for(int i = index; i < num.length(); i++){
			long digit = Long.parseLong(num.substring(index, i+1));
			if(i != index && num.charAt(index) == '0') break;
			if(digit > Integer.MAX_VALUE || digit < Integer.MIN_VALUE)break;
			if(index == 0) addOperators(num, target, i+1, ""+digit, curVal + digit, digit, result);
			else{
				addOperators(num, target, i+1, currStr + "+" + digit, curVal + digit, digit, result);
				addOperators(num, target, i+1, currStr + "-" + digit, curVal - digit, -1*digit, result);
				addOperators(num, target, i+1, currStr + "*" + digit, curVal -mult +digit*mult , mult*digit, result);
			}
		}
		
		return;
	}
	public static void main(String[] args) {
		System.out.println(addOperators("123", 6));
		System.out.println(addOperators("232", 0));
		System.out.println(addOperators("105", 5));

	}

}
