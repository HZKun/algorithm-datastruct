package vip.qmwk.leetcode.backtracking;

import java.util.Arrays;

public class Test_733 {


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int oldColor = image[sr][sc];
        boolean[][] changed = new boolean[row][col];
        colorFill(image,sr,sc,oldColor,newColor,changed,row - 1,col - 1);
        return image;
    }

    private static void colorFill(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] changed, int row, int col){
        // 终止条件
        if(sr > row || sr < 0 || sc > col || sc < 0){
            return;
        }
        // 判断是否修改当前像素
        if(image[sr][sc] != oldColor || changed[sr][sc]){
            return;
        }
        image[sr][sc] = newColor;
        changed[sr][sc] = true;

        // 向上
        colorFill(image,sr-1,sc,oldColor,newColor,changed,row,col);
        // 向下
        colorFill(image,sr+1,sc,oldColor,newColor,changed,row,col);
        // 向左
        colorFill(image,sr,sc-1,oldColor,newColor,changed,row,col);
        // 向右
        colorFill(image,sr,sc+1,oldColor,newColor,changed,row,col);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] result = floodFill(image, 1, 1, 2);
        System.out.println(Arrays.toString(result));
    }
}
