package vip.qmwk.leetcode.hot100;

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
 */
public class Test_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] num = new int[length1 + length2];
        int avg = (length1 + length2 + 1)/2;
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while(index1 < length1 && index2 < length2){
            if(nums1[index1] < nums2[index2]){
                num[count] = nums1[index1];
                index1++;
            }else{
                num[count] = nums2[index2];
                index2++;
            }
            count++;
            if(count - 1 == avg){
                break;
            }
        }

        if(count - 1 == avg){
            if((length1 + length2 + 1)%2 == 0){
                return num[avg - 1];
            }else{
                return (num[avg - 1] + num[avg])/2.0;
            }
        }
        while(index1 < length1){
            num[count] = nums1[index1];
            index1++;
            count++;
            if(count - 1 == avg){
                break;
            }
        }
        while(index2 < length2){
            num[count] = nums2[index2];
            index2++;
            count++;
            if(count - 1 == avg){
                break;
            }
        }
        if((length1 + length2 + 1)%2 == 0){
            return num[avg - 1];
        }else{
            return (num[avg - 1] + num[avg])/2.0;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,1};
        int[] num2 = {};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
