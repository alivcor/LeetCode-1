package com.leetcode.solved;

public class AddStrings {
	public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        while(index1 >= 0 || index2 >= 0){
            int sum = carry;
            sum += (index1 >= 0) ? num1.charAt(index1--) - '0' : 0;
            sum += (index2 >= 0) ? num2.charAt(index2--) - '0' : 0;
            carry = sum/10;
            sb.append(sum%10);
        }
        
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

}
