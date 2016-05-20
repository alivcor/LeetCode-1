package com.leetcode.solved;

public class GasStation {
/*
If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
Proof to the first point: say there is a point C between A and B -- that is A can reach C but cannot reach B.
Since A cannot reach B, the gas collected between A and B is short of the cost.
Starting from A, at the time when the car reaches C, it brings in gas >= 0, and the car still cannot reach B. 
Thus if the car just starts from C, it definitely cannot reach B.


If the total number of gas is bigger than the total number of cost. There must be a solution.
 
 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null) return -1;
        
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
