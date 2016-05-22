package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MinimumHeightTrees {

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n == 0) return Collections.EMPTY_LIST;
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < edges.length; i++){
			graph.computeIfAbsent(edges[i][0], k -> new ArrayList()).add(edges[i][1]);
			graph.computeIfAbsent(edges[i][1], k -> new ArrayList()).add(edges[i][0]);
		}
		
		Set<Integer> leaves = new HashSet<Integer>();
		for(Integer key : graph.keySet()){
			if(graph.get(key).size() == 1) leaves.add(key);
		}
		while(n > 2){
			n -= leaves.size();
			Set<Integer> newLeaves = new HashSet<Integer>();
			for(Integer leaf : leaves) {
				Integer dest = graph.get(leaf).get(0);
				graph.get(dest).remove(leaf);
				if(graph.get(dest).size() == 1) newLeaves.add(dest);
				graph.remove(leaf);
				
			}
			leaves = newLeaves;
		}
		return new ArrayList<>(leaves);
    }
	
	public static void main(String[] args){
		int n = 6;
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(findMinHeightTrees(n, edges));
	}

}
