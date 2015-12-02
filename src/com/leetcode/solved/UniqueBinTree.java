package com.leetcode.solved;

public class UniqueBinTree {
	
	private static long factorialN(int n){
			if(n == 0) return 1;
		
			return factorialN(n-1)*n;
	    }
    public static int numTrees(int n) {
        if(n <= 0) return 0;
        
        long denominator = Integer.MAX_VALUE;
        
        if(n%2 == 0){
        	denominator = factorialN(n/2);
        }else{
        	denominator = factorialN((n+1)/2);
        }
        
        long prod = 1;
        for(int i = n+2; i <= 2*n; i++){
        	if(i%2 == 0){
        		prod = prod * 2;
        	}else{
        		prod = prod * i;
        	}
        }
        
        
        long result = prod/denominator;
        int intRes = (int)result;
        return intRes;
        
    }
	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(6));
	}

}
