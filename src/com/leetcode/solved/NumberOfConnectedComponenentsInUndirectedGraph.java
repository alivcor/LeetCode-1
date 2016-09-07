package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfConnectedComponenentsInUndirectedGraph {
	public int countComponentsVersionDFS(int n, int[][] edges) {
        if(n <= 1) return n;
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i,new HashSet<Integer>());
        
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int countCC = 0;
        Set<Integer> covered = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            if(covered.contains(i)) continue;
            countCC++;
            explore(i,covered,graph);
        }
        
        return countCC;
    }
    
    private void explore(int startNode, Set<Integer> covered,Map<Integer,Set<Integer>> graph){
        covered.add(startNode);
        for(Integer neighbor : graph.get(startNode)){
            if(covered.contains(neighbor)) continue;
            explore(neighbor,covered,graph);
        }
    }
    
    public int countComponentsVersionUnionFind(int n, int[][] edges) {
        int[] rep = new int[n];
        
        for(int i = 0; i < rep.length; i++) rep[i]  = i;
        
        for(int i = 0; i < edges.length; i++){
            int rep1 = findRoot(edges[i][0], rep);
            int rep2 = findRoot(edges[i][1], rep);
            
            if(rep1 != rep2){
                rep[rep2] = rep1;
                n--;
            }
        }
        return n;
    }
    
    private int findRoot(int val, int[] rep){
        while(val != rep[val]){
            rep[val] = rep[rep[val]];
            val = rep[val];
        }
        return val;
    }
}
