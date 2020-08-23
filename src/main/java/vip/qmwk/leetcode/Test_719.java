package vip.qmwk.leetcode;

import java.util.Arrays;

/**
 * @author hzk
 * @Description: 找出第 k 小的距离对
 * @date 2020/8/24 0:42
 */
public class Test_719 {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];
        while (min < max) {
            int mid = min + (max-min)/2;
            // 计算（left,right）中小于mid的数量
            int count = 0;
            int left = 0;
            for (int right = left;right<nums.length; right++){
                    while(nums[right] - nums[left] > mid){
                        left++;
                    }
                    count += right - left;
            }
            if(count >= k){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
}
