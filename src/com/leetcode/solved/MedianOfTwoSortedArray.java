package com.leetcode.solved;

public class MedianOfTwoSortedArray {

	private double findMedian(int A[], int i, int B[], int j){
        double maxLeft = (i == 0) ? B[j-1] : (j == 0) ? A[i-1] : Integer.max(A[i-1],B[j-1]);
        if((A.length + B.length)%2 == 1) return maxLeft;
        double minRight = (j == B.length) ? A[i] : (i == A.length) ? B[j] : Integer.min(A[i],B[j]);
        return (maxLeft + minRight)/2;
    }
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        if(A.length > B.length) return findMedianSortedArrays(B,A);
        
        int imax = A.length;
        int imin = 0;
        int i = 0;
        int j = 0;
        while(imin <= imax){
            i = (imin + imax)/2;
            j = (A.length + B.length + 1)/2 - i;
            if(i > 0 && j < B.length && A[i-1] > B[j]) imax = i-1;
            else if(i < A.length && j > 0 && B[j-1] > A[i]) imin = i+1;
            else break;
        }
        return findMedian(A,i,B,j);
    }
}
