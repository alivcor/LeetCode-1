package com.leetcode.solved;

public class BulbSwitcher {

	/*
	 * For any number N, it can be represented as p * q.
	 * So, for any bulb B_n it would be switched on by p and off by q.
	 * Basically it will remain in the same state.
	 * 
	 * All numbers except squares: As along with all pair of factors,
	 * A square can be represented as p*p. So toggled only once.
	 * 
	 * So, all the bulbs at positions which are square of some number would remain on.
	 */
	public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
