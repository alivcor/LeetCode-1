package com.leetcode.solved;

public class PowXN {

	public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        
        double val = myPow(x,n/2);
        return val * val * myPow(x,n%2);
    }
}
