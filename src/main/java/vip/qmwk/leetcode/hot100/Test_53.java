package vip.qmwk.leetcode.hot100;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class Test_53 {

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int temp = 0;
        for(int x:nums){
            temp = Math.max(temp + x,x);
            max = Math.max(max,temp);
        }
        return max;
    }



    public static void main(String[] args) {
        int[] s = {5,4,-1,7,8};
        System.out.println(maxSubArray(s));
    }
}
