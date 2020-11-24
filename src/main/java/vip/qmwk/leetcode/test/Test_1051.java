package vip.qmwk.leetcode.test;



import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class Test_1051
{


    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        System.out.println(heightChecker(input));
    }


    public static int heightChecker(int[] heights) {
        if(heights.length == 1){
            return 0;
        }
        int[] old = new int[heights.length];
        for (int i = 0;i<heights.length; i++) {
            old[i] = heights[i];
        }
        int min = 0;
        for (int i = 0;i<heights.length; i++) {
            for(int j = i + 1;j<heights.length; j++){
                if(heights[i] > heights[j]){
                    min = heights[j];
                    heights[j] = heights[i];
                    heights[i] = min;
                }
            }
        }
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(old));
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if(old[i] != heights[i]){
                num++;
            }
        }
        return num;
    }
}
