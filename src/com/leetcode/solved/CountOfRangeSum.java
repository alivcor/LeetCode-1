package com.leetcode.solved;

import java.util.Arrays;

public class CountOfRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) return 0;
        return countRangeSum(nums,0,nums.length-1, lower,upper);
       
    }
    public int countRangeSum(int[] nums,int left, int right, int lower, int upper) {
       if(left == right) return (nums[left] >= lower && nums[left] <= upper) ? 1 : 0;
       
       int mid = (left + right)/2;
       
       long A[] = new long[right - mid];
       A[0] = nums[mid+1];
       for(int i = mid+2; i <= right; i++) A[i - (mid+1)] = nums[i] + A[i - (mid+2)];
       
       int count = 0;
       long sum = 0;
       Arrays.sort(A);
       for(int i = mid; i >= left; i--){
           sum += nums[i];
           count += findIndex(A,upper - sum + 0.5) - findIndex(A, lower - sum - 0.5);
       }
       
       return count
       + countRangeSum(nums,left,mid,lower,upper)
       + countRangeSum(nums,mid+1,right,lower,upper);
    }
    
 private int countRangeSumSub(int[] nums, int l, int r, int lower, int upper) {
	if (l == r) {
		return nums[l] >= lower && nums[r] <= upper ? 1 : 0;  // base case
	}
	
	int m = l + (r - l) / 2;
	long[] arr = new long[r - m];  // prefix array for the second subarray
	long sum = 0;
	int count = 0;
	
	for (int i = m + 1; i <= r; i++) {
		sum += nums[i];
		arr[i - (m + 1)] = sum;	// compute the prefix array
	}
	
	Arrays.sort(arr);  // sort the prefix array
	
	// Here we can compute the suffix array element by element.
	// For each element in the suffix array, we compute the corresponding
	// "insertion" indices of the modified bounds in the sorted prefix array
	// then the number of valid ranges sums will be given by the indices difference.
    // I modified the bounds to be "double" to avoid duplicate elements.
	sum = 0;
	for (int i = m; i >= l; i--) {
		sum += nums[i];  
		count += findIndex(arr, upper - sum + 0.5) - findIndex(arr, lower - sum - 0.5);
	}
	
	return countRangeSumSub(nums, l, m, lower, upper) + countRangeSumSub(nums, m + 1, r, lower, upper) + count;
}
    
    private int findIndex(long A[], double val){
        int left = 0; 
        int right = A.length - 1;
        
        while(left <= right){
            int mid = (left + right)/2;
            if(A[mid] <= val) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
