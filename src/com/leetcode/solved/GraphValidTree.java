package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class GraphValidTree {

	class Node{
        int val;
        Node rep;
        public Node(int val){
            this.val = val;
            rep = this;
        }
		@Override
		public String toString() {
			return "Node [val=" + val + ", rep=" + rep.val + "]";
		}
        
    }
    private int findRep(int a, Map<Integer,Node> u){
        while(a != u.get(a).rep.val){
            a = u.get(a).rep.val;
        }
        
        return a;
    }
    
    private void merge(int a, int b, Map<Integer,Node> u){
        if(a > b) merge(b,a,u);
        else u.get(b).rep = u.get(a);
    }
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,Node> union_find = new HashMap<>();
        for(int i = 0; i < n; i++) union_find.put(i,new Node(i));
            
        for(int[] edge : edges){
            int rep1 = findRep(edge[0],union_find);
            int rep2 = findRep(edge[1], union_find);
            if(rep1 != rep2) merge(rep1,rep2,union_find);
            else return false;
        }
        
        int rep = findRep(0,union_find);
        for(int i = 1; i < n; i++){
            if(findRep(i,union_find) != rep) return false;
        } 
        return true;
    }
	public static void main(String[] args) {
		GraphValidTree o = new GraphValidTree();
		int[][] edges = {{0,1},{1,2},{2,3},{1,4},{1,3}};
		System.out.println(o.validTree(5, edges));

	}

}
