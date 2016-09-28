package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        
        int count = 0;
        for(int[] point : positions){
            int root = n*point[0] + point[1];
            roots[root] = root;
            count++;
            
            for(int dir[] : dirs){
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                int oneDCor = x*n + y;
                
                if(isValidPoint(x, y, m, n, roots)){
                    int repNewPoint = findRep(x*n + y,roots);
                    if(root != repNewPoint){
                        roots[root] = repNewPoint;
                        root = repNewPoint;
                        count--;
                    }
                }
            }
            
            result.add(count);
        }
        
        return result;
    }
    
    private boolean isValidPoint(int x, int y, int m, int n, int roots[]){
        return (x >= 0 && x < m && y >= 0 && y < n && roots[x*n + y] != -1);
    }
    private int findRep(int node, int[] roots){
        while(roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }
        return node;
    }
    
    
}
