package vip.qmwk.leetcode.hot100_1;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间
 *
 * 输入：nums = [1,2,5,4,3]
 * 输出：[1,3,2]
 */
public class Test_31_littleTodo {

    public static void nextPermutation(int[] nums) {
        // 首先从后向前寻找到第一个i,使得nums[i]<nums[j]
        int firstI = nums.length - 2;
        while (firstI >= 0 && nums[firstI] >= nums[firstI + 1]) {
            firstI--;
        }
        if (firstI >= 0) {
            // 从后向前找到第一个nums[firstI]<nums[j]
            int secondI = nums.length - 1;
            while(secondI > 0 && nums[secondI] <= nums[firstI]){
                secondI--;
            }
            // 交换firstI,secondI
            int temp = nums[firstI];
            nums[firstI] = nums[secondI];
            nums[secondI] = temp;
        }
        // 从firstI到后面整个逆序
        int left = firstI + 1; int right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
