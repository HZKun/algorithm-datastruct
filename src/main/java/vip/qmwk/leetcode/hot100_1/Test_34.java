package vip.qmwk.leetcode.hot100_1;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class Test_34 {

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        if(nums.length == 1 && nums[0] == target){
            return new int[]{0, 0};
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                // 左右扩展
                int leftIndex = mid;
                while(leftIndex >= left && nums[leftIndex] == target){
                    leftIndex--;
                }
                int rightIndex = mid;
                while(rightIndex <= right && nums[rightIndex] == target){
                    rightIndex++;
                }
                if(rightIndex - 1 - leftIndex - 1 >= 1){
                    return new int[]{leftIndex + 1, rightIndex - 1};
                }else{
                    return new int[]{mid, mid};
                }
            }
            if(target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2,2};
        int[] range = searchRange(arr, 2);
        System.out.println(Arrays.toString(range));
    }
}
