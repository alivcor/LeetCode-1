package com.leetcode.solved;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Set<Integer> set = new HashSet<>();
    Deque<Integer> body = new LinkedList<>();
    int[][] food;
    int score;
    int width;
    int height;
    int foodIndex;
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        body.addFirst(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score == -1) return -1;
        int headRow = body.peekFirst()/width;
        int headCol = body.peekFirst()%width;
        
        switch(direction){
            case "U": headRow--; break;
            case "D": headRow++; break;
            case "L": headCol--; break;
            default : headCol++; 
        }
        
        int head = headRow*width + headCol;
        set.remove(body.peekLast());
        //to check if the boundarys crossed or hit any node in body.
        if(headRow < 0 || headRow == height || headCol < 0 || headCol == width || set.contains(head)) return score = -1;
        
        set.add(head);
        body.addFirst(head);
        if(foodIndex < food.length && headRow == food[foodIndex][0] && headCol == food[foodIndex][1]){
            set.add(body.peekLast());
            foodIndex++;
            return ++score;
        }
        //Normal move, remove the tail.
        body.pollLast();
        return score;
        
    }
}
