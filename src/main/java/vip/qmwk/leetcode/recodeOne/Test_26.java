package vip.qmwk.leetcode.recodeOne;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/27/11:49
 * @Description:
 */
public class Test_26 {

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums.length;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            int num1 = nums[slow];
            while(fast < nums.length && nums[fast] == num1){
                fast++;
            }
            if(fast == nums.length){
                return slow + 1;
            }
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }
}
