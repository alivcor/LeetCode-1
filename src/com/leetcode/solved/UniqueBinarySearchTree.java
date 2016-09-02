package com.leetcode.solved;

public class UniqueBinarySearchTree {
	public int numTrees(int n) {
        int[] array = new int[n+1];
        array[0] = array[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){//j is the root of the tree of size i
                array[i] += array[j-1] * array[i-j];
            }
        }
        
        return array[n];
    }
}
