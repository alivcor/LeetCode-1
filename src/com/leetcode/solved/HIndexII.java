package com.leetcode.solved;

public class HIndexII {
	
	 private static int binSearch(int array[], int start, int end){
			if(start > end) return -1;
			if(start == end){
			  if(array[start] >= start + 1) return start;  
			  return -1;
			} 
			
			int mid = (start + end)/2;
			if(mid < end && array[mid] >= mid + 1){
				if(array[mid+1] < mid + 2) return mid;
				return binSearch(array, mid + 1, end);
			}
			return binSearch(array, start, mid);
	}
	/**In case of sorted array of Citation,
	 * We can do a Binary Search and find the last
	 * element where citation[index] >= index.
	 * @param citations
	 * @return
	 */
	public static int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) return 0;
		reverse(citations);
		return 1 + binSearch(citations, 0, citations.length-1);
    }
	private static void reverse(int[] citations){
		if(citations == null || citations.length <= 1) return;
		
		int i = 0;
		while(i < citations.length - 1 - i){
			int temp = citations[i];
			citations[i] = citations[citations.length-1-i];
			citations[citations.length-1-i] = temp;
			i++;
		}
	}
	public static void main(String[] args) {
		int[] array = {0,1};
		System.out.println(hIndex(array));
		

	}

}
