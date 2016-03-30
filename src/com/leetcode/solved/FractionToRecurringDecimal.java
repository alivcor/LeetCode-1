package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FractionToRecurringDecimal {

	public static String fractionToDecimal(long numerator, long denominator) {
	       if(denominator == 0) return "";
	       StringBuilder result = new StringBuilder();
	       
	       if (numerator < 0 || denominator < 0){
	    	   if(!(numerator < 0 && denominator < 0))
	    		   result.append("-");
	    	   numerator = (numerator > 0) ? numerator : -1 * numerator;
	    	   denominator = (denominator > 0) ? denominator : -1 * denominator;
	       }
	       result.append(numerator/denominator +"");
	       if(numerator%denominator == 0) return result.toString();
	       
	       result.append(".");
	       List<Long> list = new ArrayList<Long>();
	       Set<Long> setDecimals = new HashSet<Long>();
	       numerator = (numerator%denominator) * 10;
	       StringBuilder decimalPart = new StringBuilder();
	       while(numerator != 0 && !setDecimals.contains(numerator)){
	    	   long digit = numerator/denominator;
	    	   decimalPart.append(digit);
	    	   list.add(numerator);
	    	   setDecimals.add(numerator);
	    	   numerator = (numerator%denominator) * 10;
	       }
	       
	       if(numerator == 0) {
	    	   result.append(decimalPart);
	    	   return (result.toString());
	       }
	       
	       for(int i = 0; i < list.size(); i++){
	    	   if(numerator == list.get(i)){
	    		   decimalPart.insert(i, "(");
	    		   break;
	    	   }
	       }
	       decimalPart.append(")");
    	   result.append(decimalPart);
    	   return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-2147483648,1));
//		System.out.println(fractionToDecimal(5, 10));
//		System.out.println(fractionToDecimal(5, 2));
//		System.out.println(fractionToDecimal(5, 1));
//		System.out.println(fractionToDecimal(10, 3));
//		System.out.println(fractionToDecimal(22, 7));

	}

}
