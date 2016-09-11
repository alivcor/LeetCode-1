package com.leetcode.solved;

public class IntegerReplacement {

	public int integerReplacementMemory(int n) {
        if(n <= 1) return 0;
        int[] array = new int[n+1];
        for(int i = 2; i <= n; i++){
            if(i%2 == 0) array[i] = array[i/2]+1;
            else array[i] = 1 + Integer.min(array[i-1],array[(i+1)/2] + 1);
        }
        return array[n];
    }
	
	 public int integerReplacement(int num) {
	        long n = num;
	        if(n <= 1) return 0;
	        
	        int count = 0;
	        while(n > 1){
	            if((n&1) == 0) n = n>>1;
	            
	            else if(n == 3 || (n&3) == 1) n--;
	            else n++;
	            count++;
	        }
	        return count;
	  }
}
