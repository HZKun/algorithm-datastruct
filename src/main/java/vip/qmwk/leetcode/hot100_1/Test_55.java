package vip.qmwk.leetcode.hot100_1;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标
 */
public class Test_55 {

    /**
     * 定义dp[i]为当前i坐标可到的最远距离，则dp[i] = max(dp[i-1],nums[i] + i)
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(dp[0] >= nums.length - 1){
            return true;
        }
        for(int i = 1;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1],nums[i] + i);
            if(dp[i-1] < i){
                return false;
            }
            if(dp[i] >= nums.length- 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1};
        System.out.println(canJump(nums));
    }
}
