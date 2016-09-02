package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienOrder {
	
	public static String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        List<char[]> listEdges = findEdges(words);
        
        Map<Character,Set<Character>> map = new HashMap<>();
        Map<Character,Set<Character>> degree = new HashMap<>();
        
        for(String s : words){
        	for(char c : s.toCharArray()){
        		degree.put(c, new HashSet<Character>());
        	}
        }
        
        for(char[] edge : listEdges){
            if(!map.containsKey(edge[0])) map.put(edge[0],new HashSet<Character>());
            map.get(edge[0]).add(edge[1]);
            degree.get(edge[1]).add(edge[0]);
        }
        
        Queue<Character> q = new LinkedList<Character>();
        for(char key : degree.keySet())
        	if(degree.get(key).size() == 0) q.add(key);
        
        StringBuilder result = new StringBuilder();
        
        while(!q.isEmpty()){
        	char c = q.remove();	
            result.append(c);
         
            Set<Character> listDest = map.get(c);
            if(listDest == null) continue;
            for(Character cc : listDest){
                degree.get(cc).remove(c);
                if(degree.get(cc).size() == 0) q.add(cc); 
            }
        }
        
        if (result.length() != degree.keySet().size()) return "";
        return result.toString();
    }
    
    private static char[] getEdge(String word1, String word2){
        int index = 0;
        while(index < word1.length() && index < word2.length()){
            if(word1.charAt(index) != word2.charAt(index))return new char[]{word1.charAt(index), word2.charAt(index)};
            index++;
        }
        return null;
    }
    public static List<char[]> findEdges(String[] words){
        List<char[]> edges = new ArrayList<>();
        for(int i = 1; i < words.length; i++){
            char[] edge = getEdge(words[i-1],words[i]);
            if(edge != null) edges.add(edge);
        }
        return edges;
    }
    
    public static String alienOrder2(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
    
    public static void main(String[] args){
    	String[] array = { "za","zb","ca","cb"};
    	
    	System.out.println(alienOrder(array));
    }

}
