package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };
	Map<Integer, UndirectedGraphNode> mapLabelNode = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        if(mapLabelNode.containsKey(node.label)) return mapLabelNode.get(node.label);
        
        mapLabelNode.put(node.label, new UndirectedGraphNode(node.label));
        for(UndirectedGraphNode neighbor : node.neighbors){
        	mapLabelNode.get(node.label).neighbors.add(cloneGraph(neighbor));
        }
        return mapLabelNode.get(node.label);
    }

}
