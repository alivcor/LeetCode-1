package com.leetcode.solved;

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null) return -1;
        if(gas.length == 1) return (gas[0] >= cost[0]) ? 0 : -1;
        
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
        	totalCost += cost[i];
        	totalGas += gas[i];
        	currentGas += gas[i] - cost[i];
        	if(currentGas < 0){
        		start = i + 1;
        		currentGas = 0;
        	}
        }
        
        return (totalCost <= totalGas) ? start : -1;
    }
	public static void main(String[] args) {
		int gas[] = {2,3,1};
		int cost[] = {3,1,2};
		
		System.out.println(canCompleteCircuit(gas, cost));

	}

}
