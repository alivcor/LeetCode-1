package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

	public static List<String> findItinerary(String[][] tickets) {
        if(tickets == null || tickets.length == 0) return Collections.emptyList();
        
        Map<String,List<String>> ticketMap = new HashMap<String,List<String>>();
        for(String[] ticket : tickets)
        	ticketMap.computeIfAbsent(ticket[0], k -> new ArrayList()).add(ticket[1]);
        
        ticketMap.forEach((k,v) -> Collections.sort(v));
        
        List<String> travel = new ArrayList<>(Collections.nCopies(tickets.length + 1, ""));
        if(!itinerary(ticketMap, "JFK",travel,0))return Collections.emptyList();
        return travel;
    }
    
    private static  boolean itinerary(Map<String,List<String>> ticketMap,
                String location, List<String> travel, int index){
            
            travel.set(index,location);
            if(index == travel.size() - 1) return true;
            
            if(ticketMap.get(location) == null) return false;
            
            for(int i = 0; i < ticketMap.get(location).size(); i++){
            	if("".equals(ticketMap.get(location).get(i)))continue;
            	
            	String place = ticketMap.get(location).get(i); 
            	ticketMap.get(location).set(i, "");
                if(itinerary(ticketMap, place,travel,index+1)){
                    return true;
                }
                ticketMap.get(location).set(i, place);
            }
            return false;
        
    }
 
	public static void main(String[] args) {
		String[][] tkt = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		System.out.println(findItinerary(tkt));
		

	}

}
