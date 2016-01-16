
package com.leetcode.solved;

public class PowerOfThree {
	
	/**This is valid for constant time checking of any power.
	 * If the log value is an integer, the number is a power of given.
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree(int n) {
		if(n <= 0) return false;
		double logbase3 = Math.log10(n)/Math.log10(3);
		return (logbase3%1 == 0);  
    }

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(81));
		System.out.println(isPowerOfThree(19));
		System.out.println(isPowerOfThree(243));

	}

}
