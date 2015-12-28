package com.leetcode.solved;

public class MergeSortedArrays {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int currIndex = m + n - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0){
        	if(nums1[m] > nums2[n]){
        		nums1[currIndex--] = nums1[m--];
        	}else{
        		nums1[currIndex--] = nums2[n--];
        	}
        }
        
        while(m >= 0){
        	nums1[currIndex--] = nums1[m--];
        }
        while(n >= 0){
        	nums1[currIndex--] = nums2[n--];
        }
        return;
    }
	
	public static void main(String[] args) {
		int a[] = {1,5,7,10};
		int b[] = new int[10];
		b[0] = 4;
		b[1] = 6;
		b[2] = 12;
		merge(b, 3, a, 4);

	}

}
