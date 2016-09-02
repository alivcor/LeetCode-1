package com.leetcode.solved;

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    paths(rooms,i+1,j,1);
                    paths(rooms,i-1,j,1);
                    paths(rooms,i,j+1,1);
                    paths(rooms,i,j-1,1);
                }
            }
        }
    }
    
    private void paths(int[][] rooms, int i, int j, int distance){
        if(i >= rooms.length || i < 0 || j >= rooms[0].length || j < 0 || rooms[i][j] == -1)return;
        if(distance >= rooms[i][j]) return;
        rooms[i][j] = distance;
        // System.out.println(i + "  " + j + " " + distance);
        paths(rooms,i+1,j,distance+1);
        paths(rooms,i-1,j,distance+1);
        paths(rooms,i,j+1,distance+1);
        paths(rooms,i,j-1,distance+1);
    }
}
