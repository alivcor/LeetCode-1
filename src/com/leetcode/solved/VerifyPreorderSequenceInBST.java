package com.leetcode.solved;

public class VerifyPreorderSequenceInBST {
	public static boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return (verifyPreorder(preorder,0,preorder.length-1) != null);
    }
    
    private static int[] verifyPreorder(int[] array, int start, int end){
        int root = array[start];
        if(start == end) return new int[]{root,root};
        
        int i = 1;
        for(i = start + 1; i <= end; i++){
            if(array[i] > root) break;
        }
        
        int[] left = (i > start + 1) ? verifyPreorder(array,start+1, i-1) : new int[]{root,root};
        int[] right = (i <= end) ? verifyPreorder(array,i,end) : new int[]{root,root};
        
        if(left == null || right == null || root < left[1] || root > right[0]) return null;
        
        return new int[]{ ((left != null) ? left[0] : root), ((right != null) ? right[1] : root)};
                         
    }

	public static void main(String[] args) {
		System.out.println(verifyPreorder(new int[]{10,7,4,8,6,40,23}));

	}

}
