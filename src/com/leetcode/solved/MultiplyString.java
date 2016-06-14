package com.leetcode.solved;


public class MultiplyString {
	
	public static String multiply1(String s1, String s2){
		if(s1 == null || s2 == null) return "";
		if(s1.length() == 0 || s2.length() == 0) return "0";
		
		int[] result = new int[s1.length() + s2.length()];
		for(int i = s1.length()-1 ; i >= 0; i--){
			for(int j = s2.length() - 1; j >= 0; j--){
				int resultVal = (s2.charAt(j) - 48)*(s1.charAt(i) - 48) + result[i+j+1];
				result[i+j+1] = resultVal%10;
				result[i+j]  += resultVal/10;
			}
		}
		StringBuilder resultStr = new StringBuilder();
		
		for(int val : result) if(!(resultStr.length() == 0 && val == 0)) resultStr.append(val);
		return resultStr.length() == 0 ? "0" : resultStr.toString();
	}
    
    public static String multiply(String s1, String s2){
		if(s1 == null || s2 == null) return null;
		if(s1.length() == 0 || s2.length() == 0) return "0";
		
		String result = "0";
		StringBuilder index1 = new StringBuilder();
		for(int i = s1.length()-1 ; i >= 0; i--){
			StringBuilder index2 = new StringBuilder();
			String tempSum = "";
			for(int j = s2.length() - 1; j >= 0; j--){
				int resultVal = (s2.charAt(j) - 48)*(s1.charAt(i) - 48);
				tempSum = addAll(tempSum, resultVal + index1.toString() + index2.toString());
				index2.append(0);
			}
			result += addAll(tempSum, result);
			index1.append(0);
		}
		
		return result;
	}
	
	private static String addAll(String a, String b){
		
		StringBuilder result = new StringBuilder();
		
		int iA = a.length() - 1;
		int iB = b.length() - 1;
		int carry = 0;
		while(iA >= 0 && iB >= 0){
			int sum = a.charAt(iA--) - 48 + b.charAt(iB--) - 48 + carry;
			carry = sum/10;
			result.insert(0,sum%10);
		}
		
		if(iB < 0){
			while(carry != 0 && iA >= 0){
				int sum = a.charAt(iA--) - 48 + carry;
				carry = sum/10;
				result.insert(0,sum%10);
			}
			result.insert(0,a.substring(0, iA+1));
			
		}else if(iA < 0){
			while(carry != 0 && iB >= 0){
				int sum = b.charAt(iB--) - 48 + carry;
				carry = sum/10;
				result.insert(0,sum%10);
			}
			result.insert(0,b.substring(0, iB+1));
		}
		if(carry != 0)result.insert(0,carry);
		return result.toString();
	}
	
}
