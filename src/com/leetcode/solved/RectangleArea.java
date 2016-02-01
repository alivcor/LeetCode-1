package com.leetcode.solved;

public class RectangleArea {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C-A)*(D-B);
        int areaB = (G-E)*(H-F);
        
        int overlap = 0;
        int oL = Integer.max(A,E);
        int oR = Integer.min(C,G);
        int oT = Integer.min(D,H);
        int oB = Integer.max(B,F);
        if(oL < oR && oT > oB){
            overlap = (oR - oL) * (oT - oB);
        }
        
        return areaA + areaB - overlap;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
