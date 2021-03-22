package vip.qmwk.leetcode.hot100_1;

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
        // 最大子序和结果
        int max = Integer.MIN_VALUE;
        // 前一位的最大子序和结果
        int tempMax = 0;
        for(int i = 0;i<nums.length;i++){
            tempMax = Math.max(nums[i], tempMax + nums[i]);
            max = Math.max(max,tempMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(maxSubArray(nums));
    }
}
