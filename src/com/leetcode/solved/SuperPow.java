package com.leetcode.solved;

public class SuperPow {

	public static int superPow(int a, int[] b) {
		if(b.length == 0) return 1;
		int result = 1;
		a = a%1337;
		for(int i = 0; i < b.length; i++){
			result = ((pow(result,10)%1337)*(pow(a, b[i])%1337))%1337;
		}
		return (int) result;
    }
	public static int pow(int a, int b){
		if(b == 0) return 1;
		if(b == 1) return a%1337;
		
		int prod = pow(a,b/2)%1337;
		prod = (prod*prod)%1337;
		if(b%2 == 0) return prod;
		return (prod*a)%1337;
	}
	public static void main(String[] args) {
		System.out.println(superPow(2,new int[]{1,2,1}));

	}

}
