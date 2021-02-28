package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_90 {


    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集
     * 输入: [1,2,2]
     * 输出:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result,path,nums,0);
        return result;

    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int index){
        result.add(new ArrayList<>(path));
        for(int i = index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            dfs(result,path,nums,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3};
        List<List<Integer>> lists = subsetsWithDup(arr);
        System.out.println(lists);
    }

}
