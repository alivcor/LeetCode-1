package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ID444_SequenceReconstruction {
	//Using topological sort
	public boolean sequenceReconstructionTopologicalSort(int[] org, int[][] seqs) {
        if(org == null || seqs == null) return org == null && seqs == null;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();
        
        Set<Integer> covered = new HashSet<>();
        for(int i = 0; i < org.length; i++) degree.put(org[i], 0);
        for(int i = 0; i < seqs.length; i++){
            for(int j = 0; j < seqs[i].length; j++){
                covered.add(seqs[i][j]);
                if(!graph.containsKey(seqs[i][j])) graph.put(seqs[i][j], new HashSet<>());
                for(int k = j + 1; k < seqs[i].length; k++){
                    if(seqs[i][j] == seqs[i][k]) return false;
                    if(!graph.get(seqs[i][j]).contains(seqs[i][k])){
                        graph.get(seqs[i][j]).add(seqs[i][k]);
                        degree.put(seqs[i][k], degree.getOrDefault(seqs[i][k], 0) + 1);
                    }
                }
            }
        }
        
        if(covered.size() != org.length) return false;
        Queue<Integer> q = new LinkedList<Integer>();
        for(Integer key : degree.keySet()) if(degree.get(key) == 0) q.add(key);
        if(q.size() != 1) return false;
        
        int count = 0;
        while(!q.isEmpty()){
            count++;
            Integer top = q.poll();
            if(graph.containsKey(top)){
                for(Integer val : graph.get(top)){
                    degree.put(val, degree.get(val) - 1);
                    if(degree.get(val) == 0) q.add(val);
                }    
            }
            if(q.size() != 1) return count == org.length;
        }
        
        return false;
        
    }

	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if(org == null || seqs == null) return org == null && seqs == null;
        if(seqs.length == 0 && org.length > 0) return false;
            
        Map<Integer,Integer> indexes = new HashMap<>();
        Set<String> pairs = new HashSet<>();
        
        for(int i = 0; i < org.length; i++) indexes.put(org[i], i);
        
        for(int i = 0; i < seqs.length; i++){
            if(seqs[i].length > 0 && indexes.get(seqs[i][0]) == null) return false;
            for(int j = 1; j < seqs[i].length; j++){
                if(indexes.get(seqs[i][j]) == null || indexes.get(seqs[i][j]) <= indexes.get(seqs[i][j-1])) return false;
                pairs.add(seqs[i][j-1] + "_" + seqs[i][j]);
            }
        }
        // System.out.println(pairs);
        for(int i = 1; i < org.length; i++){
            if(!pairs.contains(org[i-1] + "_" + org[i])) return false;
        }
        
        return true;
        
    }
}
