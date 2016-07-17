package com.leetcode.solved;

public class SelfCrossing {
	
	public static boolean isSelfCrossing(int[] a) {
		for(int i = 3; i < a.length; i++){
			if(a[i-1] <= a[i-3] && a[i-2] <= a[i]) return true;
			//Idea when 4th line crosses first line.
			else if(i >= 4 && a[i-4] + a[i] >= a[i-2] && a[i-3] == a[i-1]) return true;
			else if(i >= 5 && a[i-1] + a[i-5] >= a[i-3] && a[i-4] + a[i] >= a[i-2] && a[i-2] >= a[i-4] && a[i-1] <= a[i-3]) return true;
		}
		return false;
    }


	public static void main(String[] args) {
		int[] array = {2,-1,1,-2};//{1,2,3,4};
		System.out.println(isSelfCrossing(array));

	}

}
