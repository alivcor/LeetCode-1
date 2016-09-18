package com.leetcode.solved;

public class SmallestRectangleEnclosingBlackPixels {
	int leftBot[] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    int rightTop[] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        
    public int minArea(char[][] image, int x, int y) {
        
        if(x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1 || image[x][y] == '0') return 0;
        
        if(x < leftBot[0]) leftBot[0] = x;
        if(x > rightTop[0]) rightTop[0] = x;
        if(y < leftBot[1]) leftBot[1] = y;
        if(y > rightTop[1]) rightTop[1] = y;
        
        image[x][y] = '0';
        minArea(image, x + 1, y);
        minArea(image, x - 1, y);
        minArea(image, x, y - 1);
        minArea(image, x, y + 1);
        
        return (rightTop[0] - leftBot[0] + 1)*(rightTop[1] - leftBot[1]  + 1);
    }
}
