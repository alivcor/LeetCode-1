package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        int[] result = new int[numCourses];
        
        Map<Integer,Set<Integer>> mapEdgesChildKey = new HashMap<>();
        Map<Integer,Set<Integer>> mapEdgesParentKey = new HashMap<>();
        Set<Integer> noPrereqs = new HashSet<>();
        for(int i = 0; i < numCourses; i++) noPrereqs.add(i);
        
        for(int i = 0; i < prerequisites.length; i++){
    		if(!mapEdgesChildKey.containsKey(prerequisites[i][0])){
    			Set<Integer> setNodes = new HashSet<>();
        		mapEdgesChildKey.put(prerequisites[i][0], setNodes);
    		}
    		if(!mapEdgesParentKey.containsKey(prerequisites[i][1])){
    			Set<Integer> setNodes = new HashSet<>();
    			mapEdgesParentKey.put(prerequisites[i][1], setNodes);
    		}
        	mapEdgesChildKey.get(prerequisites[i][0]).add(prerequisites[i][1]);
        	mapEdgesParentKey.get(prerequisites[i][1]).add(prerequisites[i][0]);
        	noPrereqs.remove(prerequisites[i][0]);
        }
        
        int index = 0;
        while(mapEdgesChildKey.size() != 0 && noPrereqs.size() != 0){
        	Set<Integer> nextLevelNoPrereq = new HashSet<>();
        	for(Integer curCourse : noPrereqs){
        		result[index++] = curCourse;
        		Set<Integer> listChilds = mapEdgesParentKey.get(curCourse);
        		if(listChilds == null) continue;
        		for(Integer curChild : listChilds){
        			mapEdgesChildKey.get(curChild).remove(curCourse);
        			if(mapEdgesChildKey.get(curChild).size() == 0){
        				nextLevelNoPrereq.add(curChild);
        				mapEdgesChildKey.remove(curChild);
        			}
        		}
        	}
        	noPrereqs = new HashSet<>(nextLevelNoPrereq);
        }
        for(Integer curCourse : noPrereqs) result[index++] = curCourse;
        if(mapEdgesChildKey.size() != 0) return new int[0];
        for(int i = 0; i < result.length; i++) System.out.println(result[i]);
        return result;
        
    }
}
