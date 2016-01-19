package com.leetcode.solved;


public class PerfectSquares {

	 /**Dynamic Programming:
	  * Start building from 0 to N.
	  * For each of the point, fill the minimum count that can be summed together to obtain N.
	  * This can be done by trying all possible options that can be used to obtain N
	 * @param n
	 * @return
	 */
	public static int numSquaresReq(int n) {
		 if(n == 0) return 0;	
		 int array[] = new int[n+1];
		 array[0] = 0;
		 array[1] = 1;
		 
		 for(int i = 2; i <= n; i++) array[i] = Integer.MAX_VALUE;
		 
		 for(int i = 2; i <= n; i++)
			 	 for(int j = 1; j*j <= i; j++)
					 if(array[i] > 1 + array[i-j*j])
						 array[i] = 1 + array[i-j*j];
					
		 
		 return array[n];	        
	 }
	
	 public static void main(String[] args) {
		System.out.println(numSquaresReq(6110));

	}

}
