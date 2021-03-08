package vip.qmwk.leetcode.hot100_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class Test_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 2){
            return result;
        }
        Arrays.sort(nums);
        // 第一位数i
        for(int i = 0;i<nums.length - 2;i++){
            while(i > 0 && nums[i] == nums[i - 1] && i<nums.length - 2){
                i++;
            }
            // 第三位数k从后往前遍历
            int k = nums.length - 1;
            // 第二位数j
            for(int j = i + 1;j<nums.length;j++){
                while(j > i + 1 && nums[j] == nums[j - 1] && j<nums.length - 1){
                    j++;
                }

                while(j < k && nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                if(j == k){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }
}
