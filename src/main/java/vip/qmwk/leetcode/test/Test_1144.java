package vip.qmwk.leetcode.test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/08/20/20:09
 * @Description:
 */
public class Test_1144 {

    public static int movesToMakeZigzag(int[] nums) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        // 奇数位比临值小
        int count1 = count(nums, 1);
        int count2 = count(copyNums, 0);
        return Math.min(count1, count2);
    }

    private static int count(int[] nums, int beginIndex){
        int count = 0;
        for (int i = beginIndex; i < nums.length; i = i+2) {
            if(i-1>=0 && nums[i-1]<=nums[i]){
                count += nums[i] - nums[i-1] + 1;
                nums[i] = nums[i-1] - 1;
            }
            if(i+1<nums.length && nums[i+1]<=nums[i]){
                count += nums[i] - nums[i+1] + 1;
                nums[i] = nums[i+1] - 1;
            }
        }
        return count;
    }
}
