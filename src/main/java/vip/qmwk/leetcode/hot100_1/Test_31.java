package vip.qmwk.leetcode.hot100_1;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间
 * <p>
 * 输入：nums = [1,2,5,4,3]
 * 输出：[1,3,2]
 */
public class Test_31 {

    public static void nextPermutation(int[] nums) {
        // 1.从后往前遍历到第一个nums[i]<nums[i + 1]
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            // 从后向前获取第一个nums[i]<nums[j]
            int j = nums.length - 1;
            while(j > i &&nums[i] >= nums[j]){
                j--;
            }
            // 交换i,j
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 从i + 1开始逆序
        reverse(i + 1,nums.length - 1,nums);
    }

    private static void reverse(int left,int right,int[] nums){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,4,3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
