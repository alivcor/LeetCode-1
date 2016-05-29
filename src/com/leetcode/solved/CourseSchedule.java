package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	
	public static  boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
		
		Map<Integer, Set<Integer>> setDep = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Set<Integer>> revEdge = new HashMap<Integer, Set<Integer>>();
		for(int i = 0; i < prerequisites.length; i++){
			setDep.computeIfAbsent(prerequisites[i][0], v -> new HashSet<>()).add(prerequisites[i][1]);
			revEdge.computeIfAbsent(prerequisites[i][1], v -> new HashSet<>()).add(prerequisites[i][0]);
		}
		
		Queue<Integer> leaves = new LinkedList<Integer>();
		for(int i = 0; i < numCourses; i++){
			if(setDep.get(i) == null || setDep.get(i).size() == 0){
				leaves.add(i);
				setDep.remove(i);
			}
		}
		
		while(!leaves.isEmpty()){
			Integer topNode = leaves.poll();
			if(setDep.get(topNode) != null && setDep.size() != 0) return false;
			
			if (revEdge.containsKey(topNode)) {
				for (Integer key : revEdge.get(topNode)) {
					setDep.get(key).remove(topNode);
					if (setDep.get(key).size() == 0) {
						leaves.add(key);
						setDep.remove(key);
					}
				}
			}
			
		}
		return setDep.size() == 0;
    }
	
	public static void main(String[] args){
		int[][] prerequisites = {{0,1},{1,2},{2,3},{4,3},{3,5}};
		System.out.println(canFinish(6, prerequisites));
	}

}
