package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
	
	public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length <= 1) return people;
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) return o2[0] - o1[0];
				return o1[1] - o2[1];
			}
		});
        
        List<int[]> result = new ArrayList<int[]>();
        int i = 0;
        while(i < people.length){
        	if(people[i][0] == people[0][0]) result.add(people[i]);
        	else result.add(people[i][1],people[i]);
        	i++;
        }
       
        return result.toArray(new int[people.length][2]);
    }

	public static void main(String[] args) {
		System.out.println(reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));

	}

}
