package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test_78 {


    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
            dfs(result, path, nums, 0, i+1);
        }
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int index, int length){
        // 终止条件
        if(path.size() == length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i<nums.length;i++){
            path.add(nums[i]);
            dfs(result, path, nums, i + 1, length);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<List<Integer>> subsets = subsets(arr);
        System.out.println(subsets);
    }
}
