package vip.qmwk.leetcode.hot100_1;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 输 入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 */
public class Test_11 {

    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        int heightLen = 0;
        while(leftIndex <= rightIndex){
            int temp = 0;
            if(height[leftIndex] < height[rightIndex]){
                heightLen = height[leftIndex];
                temp = (rightIndex - leftIndex) * heightLen;
                leftIndex++;
            }else{
                heightLen = height[rightIndex];
                temp = (rightIndex - leftIndex) * heightLen;
                rightIndex--;
            }

            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
