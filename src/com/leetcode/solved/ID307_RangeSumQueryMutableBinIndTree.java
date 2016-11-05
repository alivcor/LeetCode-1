package com.leetcode.solved;

public class ID307_RangeSumQueryMutableBinIndTree {
	int bitree[];
	int array[];
    public ID307_RangeSumQueryMutableBinIndTree(int[] nums) {
        bitree = new int[nums.length + 1];
        array = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i]);
            array[i] = nums[i];
        }
    }

    void update(int i, int val) {
    	int diff = val - array[i];
    	for(int j = i+1; j < bitree.length; j += (-j)&j){
            bitree[j] += diff;
        }
    	array[i] = val;
    }

    private int sum(int i){
    	int j = i + 1;
    	int sum = 0;
    	while(j > 0){
    		sum += bitree[j];
    		j = j&(j-1);
    	}
    	return sum;
    }
    public int sumRange(int i, int j) {
        return sum(j) - sum(i-1);
    }
    
    public static void main(String[] args){
    	ID307_RangeSumQueryMutableBinIndTree o = new ID307_RangeSumQueryMutableBinIndTree(
    			new int[]{7, 2, 7, 2, 0});
    	o.update(4, 6);
    	o.update(0, 2);
    	o.update(0, 9);
    	System.out.println(o.sumRange(4, 4));
    	o.update(3, 8);
    	System.out.println(o.sumRange(0, 4));
    	o.update(4,1);
    	System.out.println(o.sumRange(0, 3));
    	System.out.println(o.sumRange(0, 4));
    	
    }
}
