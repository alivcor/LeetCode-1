package com.leetcode.solved;

public class VerifyPreorderSerializationBT {

	public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return true;
        String[] nodes = preorder.split(",");
        int finalIndex  = isValidSerialization(nodes,0);
        
        if(finalIndex < 0 || finalIndex < nodes.length - 1) return false;
        return true;
    }
	
	public static int isValidSerialization(String[] preorder, int index) {
		if(index >= preorder.length) return -1;
		if(("#").equals(preorder[index])) return index;
        index = isValidSerialization(preorder, index + 1);
        if(index == -1) return -1;
        index = isValidSerialization(preorder, index + 1);
        
        return index;
    }
	public static void main(String[] args) {
		//System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,6,#,2,#,3,#,#"));
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

	}

}
