package vip.qmwk.leetcode.hot100;

import java.util.*;

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
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int lastIndex = nums.length - 1;
            for(int j = i + 1;j<nums.length;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while(j < lastIndex && nums[i] + nums[j] + nums[lastIndex] > 0){
                    lastIndex--;
                }
                if(j == lastIndex){
                    break;
                }
                if(nums[i] + nums[j] + nums[lastIndex] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[lastIndex]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,0,2,2};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }
}
