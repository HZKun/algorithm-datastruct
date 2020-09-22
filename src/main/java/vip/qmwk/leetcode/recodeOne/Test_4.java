package vip.qmwk.leetcode.recodeOne;

/**
 * @author hzk
 * @Description: 寻找两个正序数组的中位数
 * @date 2020/8/27 0:14
 */
public class Test_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int totalSize = size1 + size2;

        // 中位数为第(size1 + size2)/2 小的数
        if((totalSize)%2 == 0){
            //第totalSize/2与totalSize/2 + 1对应的值的平均值
            int midIndex1 = totalSize / 2, midIndex2 = totalSize / 2 + 1;
            return (getKth(nums1, nums2, midIndex1 ) + getKth(nums1, nums2, midIndex2 )) / 2.0;
        }else{
            //第(totalSize/2 + 1)对应的值的平均值
            int midIndex = totalSize / 2;
            return getKth(nums1,nums2,midIndex + 1) * 1d;
        }

    }

    // 获取两个有序数组中第K小的数---二分删除
    private static int getKth(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while(true){
            if(index1 == length1){
                return nums2[index2 + k -1];
            }
            if(index2 == length2){
                return nums1[index1 + k -1];
            }
            int half = k/2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            if(nums1[newIndex1] < nums2[newIndex2]){
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
