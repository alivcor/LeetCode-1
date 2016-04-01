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
        for(String[] currTicket : tickets){
            if(currTicket.length != 2) continue;
            String origin = currTicket[0];
            if(ticketMap.get(origin) == null) ticketMap.put(origin,new ArrayList<String>());
            ticketMap.get(origin).add(currTicket[1]);
        }
        
        for(String key : ticketMap.keySet()){
            Collections.sort(ticketMap.get(key));
        }
        
        String[] travel = new String[tickets.length + 1];
        
        if(!itinerary(ticketMap, "JFK",travel,0))return Collections.emptyList();
        
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < travel.length; i++){
        	result.add(travel[i]);
        }
        return result;
    }
    
    private static  boolean itinerary(Map<String,List<String>> ticketMap,
                String location, String[] travel, int index){
            
            travel[index] = location;
            if(index == travel.length - 1) return true;
            
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
