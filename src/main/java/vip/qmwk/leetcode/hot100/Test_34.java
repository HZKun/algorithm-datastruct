package vip.qmwk.leetcode.hot100;

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
        if(nums.length == 1){
            if(nums[0] == target){
                return new int[]{0,0};
            }else{
                return new int[]{-1,-1};
            }
        }
        int[] result = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l +(r - l)/2;
            if(nums[mid] == target){
                // 寻找左右边界
                int leftIndex = mid;
                while(leftIndex >= l && nums[leftIndex] == target){
                    leftIndex--;
                }
                int rightIndex = mid;
                while(rightIndex <= r && nums[rightIndex] == target){
                    rightIndex++;
                }
                if(rightIndex - 1 - leftIndex - 1 == 0){
                    return new int[]{mid,mid};
                }else{
                    return new int[]{leftIndex + 1,rightIndex - 1};
                }

            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;

            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,9,10};
        int[] temp = searchRange(arr, 8);
        System.out.println(Arrays.toString(temp));
    }
}
