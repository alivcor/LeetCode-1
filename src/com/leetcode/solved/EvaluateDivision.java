package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	Map<String, List<String>> graph = new HashMap<>();
    Map<String, List<Double>> weights = new HashMap<>();
    
    private void createGraph(String[][] equations, double[] values){
        int index = 0;
        for(String[] edge : equations){
            if(!graph.containsKey(edge[0])) graph.put(edge[0],new ArrayList<String>());
            if(!graph.containsKey(edge[1])) graph.put(edge[1],new ArrayList<String>());
            if(!weights.containsKey(edge[0])) weights.put(edge[0],new ArrayList<Double>());
            if(!weights.containsKey(edge[1])) weights.put(edge[1],new ArrayList<Double>());
            
            graph.get(edge[0]).add(edge[1]);
            weights.get(edge[0]).add(values[index]);
            graph.get(edge[1]).add(edge[0]);
            weights.get(edge[1]).add(1.0/values[index]);
            index++;
        }
    }
    
    private double dfs(String source, String dest, double dist,Set<String> explored){
        if(explored.contains(source) || !graph.containsKey(source)) return 0.0;
        if(source.equals(dest)) return dist;
        explored.add(source);
        for(int i = 0; i < graph.get(source).size(); i++){
            String edge = graph.get(source).get(i);
            double distance = dfs(edge, dest, dist*weights.get(source).get(i), explored);
            if(distance == 0.0) continue;
            else return distance;
        }
        explored.remove(source);
        return 0.0;
        
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        if(equations == null || queries == null || equations.length == 0 || queries.length == 0) return new double[0];
        
        createGraph(equations, values);
        double[] result = new double[queries.length];
        int index = 0;
        for(String[] edge : queries){
            double val = dfs(edge[0], edge[1], 1, new HashSet<>());
            result[index++] = (val == 0.0) ? -1.0 : val;
        }
        
        return result;
    }

}
