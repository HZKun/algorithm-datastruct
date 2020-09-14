package vip.qmwk.leetcode.recodeOne;

import java.util.Arrays;

/**
 * @author hzk
 * @Description: 移动零
 * @date 2020/9/7 0:14
 */
public class Test_283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }

    public static int[] moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
