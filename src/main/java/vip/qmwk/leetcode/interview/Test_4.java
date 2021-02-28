package vip.qmwk.leetcode.interview;

import java.util.Arrays;

/**
 * 从后往前插入nums1,从最大值开始
 */
public class Test_4 {

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m;i< nums1.length;i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}
