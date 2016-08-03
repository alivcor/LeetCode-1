package com.leetcode.solved;

public class RangeSumQueryMutable {
	class SegmentTree{
        int start;
        int end;
        int sum;
        SegmentTree left;
        SegmentTree right;
        public SegmentTree(int start, int end, int sum){
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
		
    }
    
    private SegmentTree createTree(int[] nums, int start, int end){
        if(start > end) return null;
        if(start == end) return new SegmentTree(start,end,nums[start]);
        
        int mid = (start + end)/2;
        SegmentTree root = new SegmentTree(start,end,0);
        root.left = createTree(nums,start,mid);
        root.right = createTree(nums,mid+1,end);
        
        root.sum = ((root.left == null) ? 0 : root.left.sum) + 
        		((root.right == null) ? 0 : root.right.sum);
        return root;
    }

    private void update(SegmentTree root, int index, int val){
    	if(root.start == root.end){
    		root.sum = val;
    		return;
    	}
    	
    	int mid = root.start + (root.end - root.start) / 2;
    	if (index <= mid) update(root.left, index, val);
    	else if (index > mid) update(root.right, index, val);
    	root.sum = ((root.left == null) ? 0 : root.left.sum) + 
        		((root.right == null) ? 0 : root.right.sum);
    }
    
    private int sumRange(SegmentTree root, int start, int end){
    	if(start <= root.start && end >= root.end) return root.sum;
    // 	if(start < root.start && end > root.end) return root.sum;
    	int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) return sumRange(root.left, start, end);
        if (start >= mid+1) return sumRange(root.right, start, end);
        return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
    }
    
    SegmentTree root;
    public RangeSumQueryMutable(int[] nums) {
        this.root = createTree(nums,0,nums.length-1);
    }

    void update(int i, int val) {
    	update(this.root,i,val);
    }

    public int sumRange(int i, int j) {
        return sumRange(this.root,i,j);
    }
    
}
