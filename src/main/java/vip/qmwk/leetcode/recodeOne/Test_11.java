package vip.qmwk.leetcode.recodeOne;

/**
 * 盛最多水的容器.
 *
 * @Auther: HZK
 * @Date: 2020/09/08/20:55
 * @Description:
 */
public class Test_11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int prev = 0;
        int last = height.length - 1;
        int max = (height.length - 1) * (Math.min(height[prev],height[last]));
        while(prev < last){
            if(height[prev] <= height[last]){
                prev++;
            }else{
                last--;
            }
            int currMax = (last - prev) * Math.min(height[prev],height[last]);
            max = Math.max(max,currMax);
        }
        return max;
    }
}
