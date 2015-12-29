package com.leetcode.solved;

public class AddBinary {

	private static String addZero(String s, int count){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++)
			sb.append('0');
		sb.append(s);
		return sb.toString();
	}
	public static String addBinary(String a, String b) {
		if(a == null || a == "") return b;
		if(b == null || b == "") return a;
		
		if(a.length() > b.length()){
			b = addZero(b, a.length() - b.length());
		}else{
			a = addZero(a, b.length() - a.length());
		}
		//Both string would be of same length now.
		int index = a.length() - 1;
		
		StringBuilder result = new StringBuilder();
		int carry = 0;
		while(index >= 0){
			int val  = a.charAt(index) + b.charAt(index)  - '0' - '0' + carry;
			carry = val/2;
			val = val%2;
			result.append(val);
			index--;
		}
		if(carry == 1)result.append('1');
		return result.reverse().toString();
		
    }
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));

	}

}
