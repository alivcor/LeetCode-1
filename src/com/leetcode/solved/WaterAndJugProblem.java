package com.leetcode.solved;

public class WaterAndJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) return false;
        if(z == x + y || z == x || z == y) return true;
        return z%gcd(x,y) == 0;
    }
    
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }

}
