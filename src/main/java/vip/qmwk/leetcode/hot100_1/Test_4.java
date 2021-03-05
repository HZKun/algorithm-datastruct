package vip.qmwk.leetcode.hot100_1;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 12   3
 *          45678
 *
 * 1    2   3
 *          4567
 *
 * 12           56
 *      3   4   78
 *
 * 1    2       56
 *          3   47
 *
 */
public class Test_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if(totalLength%2 == 1){
            int midIndex = totalLength/2;
            return getKMin(nums1,nums2,midIndex + 1);
        }else{
            int midIndex1 = totalLength/2 - 1; int midIndex2 = totalLength/2;
            return (getKMin(nums1,nums2,midIndex1 + 1) + getKMin(nums1,nums2,midIndex2 + 1))/2.0;
        }
    }

    /**
     * 获取第k小对应的值
     * @param nums1
     * @param nums2
     * @param k 第k小
     * @return
     */
    private static double getKMin(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true){
            if(index1 == length1){
                return nums2[index2 + k - 1];
            }
            if(index2 == length2){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }

            int half = k/2;
            int newIndex1 = Math.min(index1 + half,length1) - 1;
            int newIndex2 = Math.min(index2 + half,length2) - 1;
            if(nums1[newIndex1] < nums2[newIndex2]){
                // 去除nums1的数,newIndex已经加上了half
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }else{
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1};
        int[] num2 = {};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
